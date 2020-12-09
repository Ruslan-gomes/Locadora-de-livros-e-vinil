package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.ClientesVO;

public class ClientesDAO extends BaseDAO implements ClientesInterDAO{

	@Override
	public void Cadastrar(ClientesVO vo) throws SQLException {
		conn = getConnection();
		String sql = "INSERT INTO Clientes (Cpf, Nome, Endereco) VALUES (?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setString(3, vo.getEndereco());
			ptst.execute();
			System.out.println("Cliente Cadastrado");
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public void Deletar(ClientesVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM Clientes where CPF = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getCpf());
			ptst.execute();
			System.out.println("Cliente deletado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void Editar(ClientesVO vo) {
		conn = getConnection();
		String sql = "UPDATE Clientes SET Nome = ?, Endereco = ? WHERE Cpf = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setNString(1, vo.getNome());
			ptst.setNString(2, vo.getEndereco());
			ptst.setString(3, vo.getCpf());
			ptst.executeUpdate();
			System.out.println("Cliente Atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet Pesquisar(ClientesVO vo) {
		String sql = " ";
		conn = getConnection();
		PreparedStatement ptst = null;
		ResultSet rs = null;
		try {
			if(vo.getNome() == null)
			{
				sql = "SELECT * FROM Clientes WHERE Cpf ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getCpf() + "%");
			}
			else
			{
				sql = "SELECT * FROM Clientes WHERE Nome ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getNome() + "%");
			}
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cliente Pesquisado");
		return rs;
	}
	
	
	@Override
	public ResultSet Listar() {
		conn = getConnection();
		String sql = "SELECT * FROM Clientes";
		Statement st;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Clientes listados");
		return rs;
	}

}
