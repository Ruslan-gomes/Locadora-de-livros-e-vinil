package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import model.VO.AlugueisVO;
//import model.VO.ClientesVO;

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
			
			ptst.setString(6, aluguel.getCliente().getCpfAntigo());
			ptst.setString(7, aluguel.getNomeProdutoAntigo());
			ptst.executeUpdate();
			System.out.println("Aluguel editado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public ResultSet pesquisarAluguel(Calendar dataInicio, Calendar dataFim) {
		conn = getConnection();
		String sql = "SELECT * FROM alugueis WHERE data_emprestimo >= ? AND data_emprestimo <= ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		//conversão de Calendar para Date.SQL
		Date dateInicio = new Date(dataInicio.getTimeInMillis());
		Date dateFim = new Date(dataFim.getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, dateInicio);
			ptst.setDate(2, dateFim);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa de alugueis por data!");
		return rs;
	}
	
	@Override
	public ResultSet pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim) {
		conn = getConnection();
		String sql = "SELECT * FROM alugueis WHERE Cpf_cliente = ? AND data_emprestimo >= ? AND data_emprestimo <= ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		//conversão de Calendar para Date.SQL
		Date dateInicio = new Date(dataInicio.getTimeInMillis());
		Date dateFim = new Date(dataFim.getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setDate(2, dateInicio);
			ptst.setDate(3, dateFim);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa de alugueis por cliente!");
		return rs;
	}
	
	public ResultSet listar(){
		conn = getConnection();
		String sql = "SELECT * FROM alugueis";
		Statement st;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Alugueis listados!");
		return rs;
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


	@Override
	public ResultSet PesquisarAluguel(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "SELECT * FROM alugueis WHERE cpf_cliente = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			rs = ptst.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Alugueis listados!");
		return rs;
	}

}
