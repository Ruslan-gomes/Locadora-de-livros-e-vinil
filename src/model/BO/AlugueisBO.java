package model.BO;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import exception.ErroCadastroAluguel;
import model.DAO.AlugueisDAO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;
import model.VO.DiscosVO;
import model.VO.LivrosVO;

public class AlugueisBO implements AlugueisInterBO {
	
	public void cadastrarAluguel(AlugueisVO aluguel) throws ErroCadastroAluguel, IOException {
		AlugueisDAO dao = new AlugueisDAO();
		if(aluguel.getCliente().getCpf() != null && aluguel.getNomeProduto() != null && aluguel.getQtdAlugados() > 0 && aluguel.getDataEmprestimo() != null && aluguel.getValorTotal() > 0)
		{
			LivrosVO livro = new LivrosVO();
			livro.setTitulo(aluguel.getNomeProduto());
			DiscosVO disco = new DiscosVO();
			disco.setTitulo(aluguel.getNomeProduto());
			
			ProdutosBO<LivrosVO> livroBO = new ProdutosBO<LivrosVO>();
			ProdutosBO<DiscosVO> discoBO = new ProdutosBO<DiscosVO>();
			List<LivrosVO> listLivro = livroBO.pesquisarProduto(livro);
			List<DiscosVO> listDisco = discoBO.pesquisarProduto(disco);
			
			PessoasBO<ClientesVO> clienteBO = new PessoasBO<ClientesVO>();
			List<ClientesVO> listCliente = clienteBO.pesquisarPessoa(aluguel.getCliente());
			
			//Se for difetente de vazio é pq encontrou o cliente
			if(!listCliente.isEmpty()) {
				if(listCliente.get(0).getCpf().equals(aluguel.getCliente().getCpf())) {
					//Testes para quantidade válida de livro
					if(!listLivro.isEmpty()) {
						aluguel.setLivro(listLivro.get(0));
						if(aluguel.getLivro().getQtdExemplares() - aluguel.getQtdAlugados() >= 0){
							//Faz o cadastro
							dao.cadastrarAluguel(aluguel);
							
							//Seta a nova quantidade dispoível de exemplares
							aluguel.getLivro().setQtdExemplares(aluguel.getLivro().getQtdExemplares() - aluguel.getQtdAlugados());
							//Edita a nova quantidade disponível no BD
							livroBO.editarProduto(aluguel.getLivro());
							
							//Gera o PDF com o comprovante
							gerarPDF(aluguel);
						}else {
							throw new ErroCadastroAluguel("Quantidade inválida. Maior do que a quantidade disponível!");
						}
					}
					//Testes para quantidade válida de disco
					else if(!listDisco.isEmpty()) {
						aluguel.setDisco(listDisco.get(0));
						if(aluguel.getDisco().getQtdExemplares() - aluguel.getQtdAlugados() >= 0){
							//Faz o cadastro
							dao.cadastrarAluguel(aluguel);
							
							//Seta a nova quantidade dispoível de exemplares
							aluguel.getDisco().setQtdExemplares(aluguel.getDisco().getQtdExemplares() - aluguel.getQtdAlugados());
							//Edita a nova quantidade disponível no BD
							discoBO.editarProduto(aluguel.getDisco());
							
							//Gera o PDF com o comprovante
							gerarPDF(aluguel);
						}else throw new ErroCadastroAluguel("Quantidade inválida. Maior do que a quantidade disponível!");
					}else throw new ErroCadastroAluguel("Produto não cadastrado ou inválido!");
				}else throw new ErroCadastroAluguel("Cliente não cadastrado ou CPF inválido!");
			}else throw new ErroCadastroAluguel("Cliente não cadastrado ou CPF inválido!!");
		}else throw new ErroCadastroAluguel("Não foi possível realizar o cadastro");
	}
	
	public void cadastrarDevolucao(AlugueisVO aluguel) throws ErroCadastroAluguel, IOException {
		AlugueisDAO dao = new AlugueisDAO();
		if(aluguel.getCliente().getCpf() != null && aluguel.getNomeProduto() != null && aluguel.getDataDevolucao() != null)
		{
			//Cadastra a devolução atualizando a data de devolução na tabela alugueis
			dao.cadastrarDevolucao(aluguel);
			
			//Adicionar devolta ao estoque a quantidade que foi devolvida
			LivrosVO livro = new LivrosVO();
			livro.setTitulo(aluguel.getNomeProduto());
			DiscosVO disco = new DiscosVO();
			disco.setTitulo(aluguel.getNomeProduto());
			
			ProdutosBO<LivrosVO> livroBO = new ProdutosBO<LivrosVO>();
			ProdutosBO<DiscosVO> discoBO = new ProdutosBO<DiscosVO>();
			List<LivrosVO> listLivro = livroBO.pesquisarProduto(livro);
			List<DiscosVO> listDisco = discoBO.pesquisarProduto(disco);
			
			//Pesquisa as informações do aluguel devolvido para atualizar a quantidade devolvida
			List<AlugueisVO> aluguelDevolvido = pesquisarAluguelDevolvido(aluguel);
			
			//Se o produto for um livro
			if(!listLivro.isEmpty()) {
				//Soma a quantidade de exemplares com a quantidade que foi devolvida e edita o produto com a quantidade total atualizada
				listLivro.get(0).setQtdExemplares(listLivro.get(0).getQtdExemplares() + aluguelDevolvido.get(0).getQtdAlugados());
				livroBO.editarProduto(listLivro.get(0));
			}
			//Se o produto for um disco
			else if(!listDisco.isEmpty()) {
				listDisco.get(0).setQtdExemplares(listDisco.get(0).getQtdExemplares() + aluguelDevolvido.get(0).getQtdAlugados());
				discoBO.editarProduto(listDisco.get(0));
			}else throw new ErroCadastroAluguel("Houve um erro. Verifique as informações e tente novamente!");
		}else throw new ErroCadastroAluguel("Houve um erro. Verifique as informações e tente novamente!");
	}
	
	public void deletarAluguel(AlugueisVO aluguel) {
		AlugueisDAO dao = new AlugueisDAO();
		dao.deletarAluguel(aluguel);
	}
	
	public void editarAluguel(AlugueisVO aluguel) {
		AlugueisDAO dao = new AlugueisDAO();
		dao.editarAluguel(aluguel); 
	}
	
	@Override
	public List<AlugueisVO> pesquisarAluguel(Calendar dataInicio, Calendar dataFim) {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.pesquisarAluguel(dataInicio, dataFim);
		
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		
		try {
			while(rs.next())
			{
				Calendar dataCalendar1 = Calendar.getInstance();
				Calendar dataCalendar2 = Calendar.getInstance();
				AlugueisVO vo = new AlugueisVO();
				ClientesVO cliente = new ClientesVO();
				cliente.setCpf(rs.getString("Cpf_cliente"));
				vo.setCliente(cliente);
				vo.setNomeProduto(rs.getString("Nome_produto"));
				vo.setQtdAlugados(rs.getInt("Qtd_alugada"));
				dataCalendar1.setTime(rs.getDate("Data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar1);
				dataCalendar2.setTime(rs.getDate("Data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
				vo.setValorTotal(rs.getDouble("valor_total"));
				alugueis.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}

	@Override
	public List<AlugueisVO> pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim) {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.pesquisarAluguelCliente(aluguel, dataInicio, dataFim);
		
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		
		try {
			while(rs.next())
			{
				Calendar dataCalendar1 = Calendar.getInstance();
				Calendar dataCalendar2 = Calendar.getInstance();
				AlugueisVO vo = new AlugueisVO();
				ClientesVO cliente = new ClientesVO();
				cliente.setCpf(rs.getString("Cpf_cliente"));
				vo.setCliente(cliente);
				vo.setNomeProduto(rs.getString("Nome_produto"));
				vo.setQtdAlugados(rs.getInt("Qtd_alugada"));
				dataCalendar1.setTime(rs.getDate("Data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar1);
				dataCalendar2.setTime(rs.getDate("Data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
				vo.setValorTotal(rs.getDouble("valor_total"));
				
				System.out.println(dataCalendar1.getTime());
				System.out.println(dataCalendar2.getTime());
				alugueis.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}

	@Override
	public List<AlugueisVO> listar() {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.listar();
		
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		
		try {
			while(rs.next()) {
				AlugueisVO vo = new AlugueisVO();
				ClientesVO cliente = new ClientesVO();
				cliente.setCpf(rs.getString("cpf_cliente"));
				vo.setCliente(cliente);
				vo.setNomeProduto(rs.getString("nome_produto"));
				vo.setQtdAlugados(rs.getInt("qtd_alugada"));
				
				Calendar dataCalendar = Calendar.getInstance();
				dataCalendar.setTime(rs.getDate("data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar);
				
				Calendar dataCalendar2 = Calendar.getInstance();
				dataCalendar2.setTime(rs.getDate("data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
				
				vo.setValorTotal(rs.getDouble("valor_total"));
				
				alugueis.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}
	
	public AlugueisVO relatorioFaturaMensal(Calendar mes) {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.faturaMensal(mes);
		AlugueisVO vo = new AlugueisVO();
		
		try {
			while(rs.next())
			{
				vo.setValorTotal(rs.getDouble("valor_total"));
				vo.setQtdAlugados(rs.getInt("qtd_alugado"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<AlugueisVO> pesquisarAluguel(AlugueisVO aluguel) {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.PesquisarAluguel(aluguel);
		
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		
		try {
			while(rs.next()) {
				AlugueisVO vo = new AlugueisVO();
				ClientesVO cliente = new ClientesVO();
				cliente.setCpf(rs.getString("cpf_cliente"));
				vo.setCliente(cliente);
				vo.setNomeProduto(rs.getString("nome_produto"));
				vo.setQtdAlugados(rs.getInt("qtd_alugada"));
				
				Calendar dataCalendar = Calendar.getInstance();
				dataCalendar.setTime(rs.getDate("data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar);
				
				Calendar dataCalendar2 = Calendar.getInstance();
				dataCalendar2.setTime(rs.getDate("data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
				
				vo.setValorTotal(rs.getDouble("valor_total"));
				
				alugueis.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}
	
	@Override
	public List<AlugueisVO> pesquisarAluguelDevolvido(AlugueisVO aluguel) {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.PesquisarAluguelDevolvido(aluguel);
		
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		
		try {
			while(rs.next()) {
				AlugueisVO vo = new AlugueisVO();
				ClientesVO cliente = new ClientesVO();
				cliente.setCpf(rs.getString("cpf_cliente"));
				vo.setCliente(cliente);
				vo.setNomeProduto(rs.getString("nome_produto"));
				vo.setQtdAlugados(rs.getInt("qtd_alugada"));
				
				Calendar dataCalendar = Calendar.getInstance();
				dataCalendar.setTime(rs.getDate("data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar);
				
				Calendar dataCalendar2 = Calendar.getInstance();
				dataCalendar2.setTime(rs.getDate("data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
				
				vo.setValorTotal(rs.getDouble("valor_total"));
				
				alugueis.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}
	
	public static void gerarPDF(AlugueisVO aluguel) {
		Document doc = new Document();
		String arquivoPDF = "notaFiscal.pdf";
		
		try{
			//Criando o arquivo
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
			doc.open();

			Paragraph p = new Paragraph("LOCADORA DE LIVROS & VINIL");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph(" "); //Paragrafo para pular linha
			doc.add(p);
			p = new Paragraph("Comprovante de aluguel");
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph(" "); //Paragrafo para pular linha
			doc.add(p);
		
			p = new Paragraph(new Phrase("CPF do cliente: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));
			p.add(new Phrase(aluguel.getCliente().getCpf(), FontFactory.getFont(FontFactory.TIMES)));
			doc.add(p);
			
			p = new Paragraph(new Phrase("Produto: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));
			p.add(new Phrase(aluguel.getNomeProduto(), FontFactory.getFont(FontFactory.TIMES)));
			doc.add(p);
			
			p = new Paragraph(new Phrase("Quantidade: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));
			p.add(new Phrase(aluguel.getQtdAlugados()+"", FontFactory.getFont(FontFactory.TIMES)));
			doc.add(p);
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			p = new Paragraph(new Phrase("Data do emprestimo: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));
			p.add(new Phrase(format.format(aluguel.getDataEmprestimo().getTimeInMillis()), FontFactory.getFont(FontFactory.TIMES)));
			doc.add(p);
			
			p = new Paragraph(new Phrase("Valor total: ", FontFactory.getFont(FontFactory.TIMES_BOLD)));
			DecimalFormat df = new DecimalFormat("0.00");
		    df.setMaximumFractionDigits(2);
		    String vFormatado = df.format(aluguel.getValorTotal());
			p.add(new Phrase("R$"+vFormatado, FontFactory.getFont(FontFactory.TIMES)));
			doc.add(p);
			
			p = new Paragraph(" "); //Paragrafo para pular linha
			doc.add(p);
			
			p = new Paragraph("Não tem valor fiscal", FontFactory.getFont(FontFactory.TIMES));
			p.setAlignment(1);
			doc.add(p);
			
			Calendar cal = Calendar.getInstance();
			p = new Paragraph(new Phrase(format.format(cal.getTimeInMillis()), FontFactory.getFont(FontFactory.TIMES)));
			p.setAlignment(1);
			doc.add(p);
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date hora = Calendar.getInstance().getTime();
			String dataFormatada = sdf.format(hora);
			p = new Paragraph(new Phrase(dataFormatada, FontFactory.getFont(FontFactory.TIMES)));
			p.setAlignment(1);
			doc.add(p);
			
			doc.close();
			Desktop.getDesktop().open(new File(arquivoPDF));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
