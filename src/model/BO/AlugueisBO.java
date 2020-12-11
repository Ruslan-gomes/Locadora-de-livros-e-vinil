package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.DAO.AlugueisDAO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public class AlugueisBO implements AlugueisInterBO {
	
	public void cadastrarAluguel(AlugueisVO aluguel) {
		AlugueisDAO dao = new AlugueisDAO();
		if(aluguel.getCliente().getCpf() != null && aluguel.getNomeProduto() != null && aluguel.getQtdAlugados() > 0 && aluguel.getDataEmprestimo() != null && aluguel.getValorTotal() > 0)
		{
			dao.cadastrarAluguel(aluguel);
		}
		else
		{
			System.out.println("N�o foi possivel efetuar o cadastro");
		}
		
	}
	
	public void cadastrarDevolucao(AlugueisVO aluguel) {
		AlugueisDAO dao = new AlugueisDAO();
		if(aluguel.getCliente().getCpf() != null && aluguel.getNomeProduto() != null && aluguel.getDataDevolucao() != null)
		{
			dao.cadastrarDevolucao(aluguel);
		}
		else
		{
			System.out.println("N�o foi possivel efetuar o cadastro");
		}
		
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
		
		Calendar dataCalendar1 = Calendar.getInstance();
		Calendar dataCalendar2 = Calendar.getInstance();
		
		try {
			while(rs.next())
			{
				
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
		
		Calendar dataCalendar1 = Calendar.getInstance();
		Calendar dataCalendar2 = Calendar.getInstance();
		
		try {
			while(rs.next())
			{
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
				//Date date = new Date(dataCalendar.getTimeInMillis());
				dataCalendar.setTime(rs.getDate("data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar);
				
				Calendar dataCalendar2 = Calendar.getInstance();
				//Date date2 = new Date(dataCalendar2.getTimeInMillis());
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
	
	//Todos os clientes
	public AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim) {
		/* Vai receber uma data de inicio e fim, pesquisar todos os alugu�is dentro desse espa�o de tempo
		 * e retornar um array com todos os alugu�is.
		 */
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	public AlugueisVO relatorioFaturaMensal(Calendar mes) {
		AlugueisDAO dao = new AlugueisDAO();
		ResultSet rs = dao.faturaMensal(mes);
		AlugueisVO vo = new AlugueisVO();
		
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
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
	public AlugueisVO[] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim) {
		// TODO Auto-generated method stub
		return null;
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
				//Date date = new Date(dataCalendar.getTimeInMillis());
				dataCalendar.setTime(rs.getDate("data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar);
				
				Calendar dataCalendar2 = Calendar.getInstance();
				//Date date2 = new Date(dataCalendar2.getTimeInMillis());
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
}
