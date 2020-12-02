package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import model.VO.AlugueisVO;

public class AlugueisDAO extends BaseDAO implements AlugueisInterDAO{

	@Override
	public void cadastrarAluguelLivro(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "INSERT INTO Alugueis (Cpf_cliente, Nome_produto, Qtd_alugada, Data_emprestimo) VALUES (?, ?, ?, ?)";
		PreparedStatement ptst;
		
		Date data = new Date(aluguel.getDataEmprestimo().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setString(2, aluguel.getLivro().getTitulo());
			ptst.setInt(3, aluguel.getQtdAlugados());
			ptst.setDate(4, data);
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Aluguel de livro Cadastrado");
	}
	
	@Override
	public void cadastrarAluguelDisco(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "INSERT INTO Alugueis (Cpf_cliente, Nome_produto, Qtd_alugada, Data_emprestimo) VALUES (?, ?, ?, ?)";
		PreparedStatement ptst;
		
		Date data = new Date(aluguel.getDataEmprestimo().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setString(2, aluguel.getDisco().getTitulo());
			ptst.setInt(3, aluguel.getQtdAlugados());
			ptst.setDate(4, data);
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Aluguel de disco Cadastrado");
		
	}

	@Override
	public void cadastrarDevolucaoLivro(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "UPDATE Alugueis SET Data_devolucao = ? WHERE Cpf_cliente = ? AND Nome_produto = ?";
		PreparedStatement ptst;
		
		Date data = new Date(aluguel.getDataDevolucao().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, data);
			ptst.setString(2, aluguel.getCliente().getCpf());
			ptst.setString(3, aluguel.getLivro().getTitulo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void cadastrarDevolucaoDisco(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "UPDATE Alugueis SET Data_devolucao = ? WHERE Cpf_cliente = ? AND Nome_produto = ?";
		PreparedStatement ptst;
		
		Date data = new Date(aluguel.getDataDevolucao().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setDate(1, data);
			ptst.setString(2, aluguel.getCliente().getCpf());
			ptst.setString(3, aluguel.getDisco().getTitulo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletarAluguel(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "DELETE FROM Alugueis WHERE Cpf_cliente = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void editarAluguelLivro(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "UPDATE Alugueis SET Nome_produto = ?, Qtd_alugada = ?, Data_emprestimo = ?, Data_devolucao = ? WHERE Cpf = ?";
		PreparedStatement ptst;
		
		Date data1= new Date(aluguel.getDataDevolucao().getTimeInMillis());
		Date data2 = new Date(aluguel.getDataEmprestimo().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getLivro().getTitulo());
			ptst.setInt(2, aluguel.getQtdAlugados());
			ptst.setDate(3, data2);
			ptst.setDate(4, data1);
			ptst.setString(5, aluguel.getCliente().getCpf());
			ptst.executeUpdate();
			System.out.println("Aluguel de livro Editado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void editarAluguelDisco(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "UPDATE Alugueis SET Nome_produto = ?, Qtd_alugada = ?, Data_emprestimo = ?, Data_devolucao = ? WHERE Cpf = ?";
		PreparedStatement ptst;
		
		Date data1= new Date(aluguel.getDataDevolucao().getTimeInMillis());
		Date data2 = new Date(aluguel.getDataEmprestimo().getTimeInMillis());
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getDisco().getTitulo());
			ptst.setInt(2, aluguel.getQtdAlugados());
			ptst.setDate(3, data2);
			ptst.setDate(4, data1);
			ptst.setString(5, aluguel.getCliente().getCpf());
			ptst.executeUpdate();
			System.out.println("Aluguel de disco Editado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public AlugueisVO pesquisarAluguelLivro(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "SELECT * Alugueis WHERE Cpf_cliente = ? AND Nome_produto = ?";
		PreparedStatement ptst;
		ResultSet rs;
		AlugueisVO vo = new AlugueisVO();
		
		Calendar dataCalendar1 = Calendar.getInstance();
		Calendar dataCalendar2 = Calendar.getInstance();
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setString(2, aluguel.getLivro().getTitulo());
			rs = ptst.executeQuery();
			while(rs.next())
			{
				vo.getCliente().setCpf(rs.getString("Cpf_cliente"));
				vo.getLivro().setTitulo(rs.getString("Nome_produto"));
				vo.setQtdAlugados(rs.getInt("Qtd_alugada"));
				dataCalendar1.setTime(rs.getDate("Data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar1);
				dataCalendar2.setTime(rs.getDate("Data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	
	@Override
	public AlugueisVO pesquisarAluguelDisco(AlugueisVO aluguel) {
		conn = getConnection();
		String sql = "SELECT * Alugueis WHERE Cpf_cliente = ? AND Nome_produto = ?";
		PreparedStatement ptst;
		ResultSet rs;
		AlugueisVO vo = new AlugueisVO();
		
		Calendar dataCalendar1 = Calendar.getInstance();
		Calendar dataCalendar2 = Calendar.getInstance();
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, aluguel.getCliente().getCpf());
			ptst.setString(2, aluguel.getLivro().getTitulo());
			rs = ptst.executeQuery();
			while(rs.next())
			{
				vo.getCliente().setCpf(rs.getString("Cpf_cliente"));
				vo.getDisco().setTitulo(rs.getString("Nome_produto"));
				vo.setQtdAlugados(rs.getInt("Qtd_alugada"));
				dataCalendar1.setTime(rs.getDate("Data_emprestimo"));
				vo.setDataEmprestimo(dataCalendar1);
				dataCalendar2.setTime(rs.getDate("Data_devolucao"));
				vo.setDataDevolucao(dataCalendar2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

}
