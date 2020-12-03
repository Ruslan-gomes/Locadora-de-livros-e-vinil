package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public class AlugueisDAO extends BaseDAO implements AlugueisInterDAO{

	@Override
	public void cadastrarAluguel(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "INSERT INTO Alugueis (Cpf_cliente, Nome_produto, Qtd_alugada, Data_emprestimo, valor_total) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		
		Date data = new Date(aluguel.getDataEmprestimo().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setString(2, aluguel.getNomeProduto());
			ptst.setInt(3, aluguel.getQtdAlugados());
			ptst.setDate(4, data);
			ptst.setDouble(5, aluguel.getValorTotal());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Aluguel Cadastrado");
	}
	

	@Override
	public void cadastrarDevolucao(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "UPDATE Alugueis SET Data_devolucao = ? WHERE Cpf_cliente = ? AND Nome_produto = ?";
		PreparedStatement ptst;
		
		Date data = new Date(aluguel.getDataDevolucao().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, data);
			ptst.setString(2, aluguel.getCliente().getCpf());
			ptst.setString(3, aluguel.getNomeProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Devolução cadastrada");
	}
	

	@Override
	public void deletarAluguel(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "DELETE FROM Alugueis WHERE Cpf_cliente = ? AND nome_produto = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setString(2, aluguel.getNomeProduto());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Aluguel deletado!");
	}

	@Override
	public void editarAluguel(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "UPDATE Alugueis SET Nome_produto = ?, Qtd_alugada = ?, Data_emprestimo = ?, Data_devolucao = ?, valor_total = ? WHERE cpf_cliente = ? AND nome_produto = ?";
		PreparedStatement ptst;
		
		Date data1= new Date(aluguel.getDataDevolucao().getTimeInMillis());
		Date data2 = new Date(aluguel.getDataEmprestimo().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getNomeProduto());
			ptst.setInt(2, aluguel.getQtdAlugados());
			ptst.setDate(3, data2);
			ptst.setDate(4, data1);
			ptst.setDouble(5, aluguel.getValorTotal());
			
			ptst.setString(6, aluguel.getCliente().getCpf());
			ptst.setString(7, aluguel.getNomeProduto());
			ptst.executeUpdate();
			System.out.println("Aluguel editado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public List<AlugueisVO> pesquisarAluguel(Calendar dataInicio, Calendar dataFim) {
		conn = getConnection();
		String sql = "SELECT * FROM alugueis WHERE data_emprestimo >= ? AND data_emprestimo <= ?";
		PreparedStatement ptst;
		ResultSet rs;
		
		//conversão de Calendar para Date.SQL
		Date dateInicio = new Date(dataInicio.getTimeInMillis());
		Date dateFim = new Date(dataFim.getTimeInMillis());
		
		Calendar dataCalendar1 = Calendar.getInstance();
		Calendar dataCalendar2 = Calendar.getInstance();
		
		// lista a ser retornada
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, dateInicio);
			ptst.setDate(2, dateFim);
			rs = ptst.executeQuery();
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
		System.out.println("Pesquisa de alugueis por data!");
		return alugueis;
	}
	
	@Override
	public List<AlugueisVO> pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim) {
		conn = getConnection();
		String sql = "SELECT * FROM alugueis WHERE Cpf_cliente = ? AND data_emprestimo >= ? AND data_emprestimo <= ?";
		PreparedStatement ptst;
		ResultSet rs;
		
		//conversão de Calendar para Date.SQL
		Date dateInicio = new Date(dataInicio.getTimeInMillis());
		Date dateFim = new Date(dataFim.getTimeInMillis());
		
		Calendar dataCalendar1 = Calendar.getInstance();
		Calendar dataCalendar2 = Calendar.getInstance();
		
		// lista a ser retornada
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setDate(2, dateInicio);
			ptst.setDate(3, dateFim);
			rs = ptst.executeQuery();
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
		System.out.println("Pesquisa de alugueis por cliente!");
		return alugueis;
	}
	
	public List<AlugueisVO> listar(){
		conn = getConnection();
		String sql = "SELECT * FROM alugueis";
		Statement st;
		ResultSet rs;
		List<AlugueisVO> alugueis = new ArrayList<AlugueisVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Alugueis listados!");
		return alugueis;
	}
	
	public double faturaMensal(Calendar mes) {
		double valorTotal = 0;
		conn = getConnection();
		String sql = "SELECT valor_total FROM relatorio WHERE data_emprestimo >= ? and data_emprestimo <= ?";
		PreparedStatement ptst;
		ResultSet rs;
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(mes.get(Calendar.YEAR), mes.get(Calendar.MONTH), 1);
		Date dataInicio = new Date(cal1.getTimeInMillis());
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(mes.get(Calendar.YEAR), mes.get(Calendar.MONTH), 31);
		Date dataFim = new Date(cal2.getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, dataInicio);
			ptst.setDate(2, dataFim);
			rs = ptst.executeQuery();
			while(rs.next()) {
				valorTotal += rs.getDouble("valor_total");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fatura mensal calculada!");
		return valorTotal;
	}

}
