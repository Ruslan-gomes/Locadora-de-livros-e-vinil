package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.FuncionariosVO;

public class FuncionariosDAO extends BaseDAO implements FuncionariosInterDAO{

	@Override
	public void Cadastrar(FuncionariosVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO Funcionarios (Cpf, Nome, Endereco, login, senha, cargo) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getLogin());
			ptst.setString(5, vo.getSenha());
			ptst.setString(6, vo.getCargo());
			ptst.execute();
			System.out.println("Funcionário Cadastrado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void Deletar(FuncionariosVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM Funcionarios where Id_func = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.execute();
			System.out.println("Funcionario deletado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Editar(FuncionariosVO vo) {
		conn = getConnection();
		String sql = "UPDATE Funcionarios SET Cpf = ?, Nome = ?, Endereco = ?, Login = ?, Senha = ?, Cargo = ? WHERE Id_func = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getCpf());
			ptst.setString(2, vo.getNome());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getLogin());
			ptst.setString(5, vo.getSenha());
			ptst.setString(6, vo.getCargo());
			ptst.setLong(7, vo.getId());
			ptst.executeUpdate();
			System.out.println("Funcionario Atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet Pesquisar(FuncionariosVO vo) {
		conn = getConnection();
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			//Pesquisa por ID
			if(vo.getId() != null) {
				String sql = "SELECT * FROM Funcionarios WHERE Id_func = ?";
				ptst = conn.prepareStatement(sql);
				ptst.setLong(1, vo.getId());
				rs = ptst.executeQuery();
			}
			//Pesquisa por CPF
			else if(vo.getLogin() != null) {
				String sql = "SELECT * FROM Funcionarios WHERE login = ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, vo.getLogin());
				rs = ptst.executeQuery();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Funcionário Pesquisado");
		return rs;
	}

	@Override
	public ResultSet Listar() {
		conn = getConnection();
		String sql = "SELECT * FROM Funcionarios";
		Statement st;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Funcionários listados");
		return rs;
	}

}
