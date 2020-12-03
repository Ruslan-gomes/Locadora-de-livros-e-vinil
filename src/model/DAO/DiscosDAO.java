package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.DiscosVO;

public class DiscosDAO extends BaseDAO implements DiscosInterDAO{
	public void cadastrar(DiscosVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO discos (titulo, estilo, nome_banda, qtd_exemplares, valor_aluguel ) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			ptst.setString(2, vo.getEstilo());
			ptst.setString(3, vo.getNomeBanda());
			ptst.setInt(4, vo.getQtdExemplares());
			ptst.setDouble(5, vo.getValorAluguel());
			ptst.execute();
			System.out.println("Disco cadastrado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void deletar(DiscosVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM livros WHERE id_disco = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate();
			
			System.out.println("Disco deletado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(DiscosVO vo) {
		conn = getConnection();
		String sql = "UPDATE discos SET titulo = ?, estilo = ?, nome_banda = ?, qtd_exemplares = ?, valor_aluguel = ? WHERE id_disco = ?";
		PreparedStatement ptst;
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			ptst.setString(2, vo.getEstilo());
			ptst.setString(3, vo.getNomeBanda());
			ptst.setInt(4, vo.getQtdExemplares());
			ptst.setDouble(5, vo.getValorAluguel());
			ptst.setInt(6, vo.getId());
			ptst.executeUpdate();
			
			System.out.println("Disco alterado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public ResultSet pesquisar(DiscosVO vo) {
		conn = getConnection();
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			//pesquisa por titulo
			if(vo.getTitulo() != null) {
				String sql = "SELECT * FROM discos WHERE titulo ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getTitulo() + "%");
				rs = ptst.executeQuery();
			}
			//pesquisa por nome da banda
			else if(vo.getNomeBanda() != null) {
				String sql = "SELECT * FROM discos WHERE nome_banda ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getNomeBanda() + "%");
				rs = ptst.executeQuery();
			}
			//pesquisa por estilo
			else if(vo.getEstilo() != null) {
				String sql = "SELECT * FROM discos WHERE estilo ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getEstilo() + "%");
				rs = ptst.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Disco pesquisado!");
		return rs;
	}
	
	//Listar todos os discos
	public ResultSet listar(){
		conn = getConnection();
		String sql = "SELECT * FROM discos";
		Statement st;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Discos listados!");
		return rs;
	}
}
