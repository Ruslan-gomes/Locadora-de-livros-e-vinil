package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public DiscosVO pesquisar(DiscosVO vo) {
		conn = getConnection();
		String sql = "SELECT * FROM discos WHERE titulo = ?";
		PreparedStatement ptst;
		ResultSet rs;
		
		DiscosVO disco = new DiscosVO();
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			rs = ptst.executeQuery();
			while(rs.next()) {
				//adicionando o resultado ao objeto livro
				disco.setId(rs.getInt("id_disco"));
				disco.setTitulo(rs.getString("titulo"));
				disco.setEstilo(rs.getString("estilo"));
				disco.setNomeBanda(rs.getString("nome_banda"));
				disco.setQtdExemplares(rs.getInt("qtd_exemplares"));
				disco.setValorAluguel(rs.getDouble("valor_aluguel"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Disco pesquisado!");
		return disco;
	}
	
	public List<DiscosVO> listar(){
		conn = getConnection();
		String sql = "SELECT * FROM discos";
		Statement st;
		ResultSet rs;
		List<DiscosVO> discos = new ArrayList<DiscosVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DiscosVO vo = new DiscosVO();
				vo.setId(rs.getInt("id_disco"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setEstilo(rs.getString("estilo"));
				vo.setNomeBanda(rs.getString("nome_banda"));
				vo.setQtdExemplares(rs.getInt("qtd_exemplares"));
				vo.setValorAluguel(rs.getDouble("valor_aluguel"));
				discos.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Discos listados!");
		return discos;
	}
}
