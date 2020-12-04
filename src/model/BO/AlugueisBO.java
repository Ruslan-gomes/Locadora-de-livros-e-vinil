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
		// Vai receber um objeto do tipo AlugueisVO e vai cadastrar esse aluguel no BD.
	}
	
	public void cadastrarDevolucao(AlugueisVO aluguel) {
		/* Vai receber um objeto do tipo AlugueisVO e vai cadastrar a data de devolução desse 
		 * aluguel no BD.
		 */
	}
	
	public void deletarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO e vai deletar ele do BD.
	}
	
	public void editarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO contendo as alterações desejadas e vai adiciona-las no BD. 
	}
	
	@Override
	public void pesquisarAluguel(Calendar dataInicio, Calendar dataFim) {
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

	}

	@Override
	public void pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim) {
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
	}

	@Override
	public void listar() {
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
	}
	
	//Todos os clientes
	public AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim) {
		/* Vai receber uma data de inicio e fim, pesquisar todos os aluguéis dentro desse espaço de tempo
		 * e retornar um array com todos os aluguéis.
		 */
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	public AlugueisVO [] relatorioFaturaMensal(Calendar mes) {
		// Vai receber um mês como parâmentro e vai retornar um array com todos os alugueis daquele mês
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}

	@Override
	public AlugueisVO[] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim) {
		// TODO Auto-generated method stub
		return null;
	}
}
