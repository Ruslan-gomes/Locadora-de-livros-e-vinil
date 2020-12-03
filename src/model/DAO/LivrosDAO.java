package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.VO.LivrosVO;


public class LivrosDAO extends BaseDAO implements LivrosInterDAO{
	//cadastrar livro
	public void cadastrar(LivrosVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO livros (titulo, genero, ano_lancamento, qtd_paginas, qtd_exemplares, valor_aluguel ) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			ptst.setString(2, vo.getGenero());
			ptst.setInt(3, vo.getAnoLancamento().getWeekYear());
			ptst.setInt(4, vo.getQtdPaginas());
			ptst.setInt(5, vo.getQtdExemplares());
			ptst.setDouble(6, vo.getValorAluguel());
			ptst.execute();
			System.out.println("Livro cadastrado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//deletar livro
	public void deletar(LivrosVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM livros WHERE id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getId());
			ptst.executeUpdate();
			
			System.out.println("Livro deletado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//editar livro
	public void editar(LivrosVO vo) {
		conn = getConnection();
		String sql = "UPDATE livros SET titulo = ?, genero = ?, ano_lancamento = ?, qtd_paginas = ?, qtd_exemplares = ?, valor_aluguel = ? WHERE id_livro = ?";
		PreparedStatement ptst;
		
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			ptst.setString(2, vo.getGenero());
			ptst.setInt(3, vo.getAnoLancamento().getWeekYear());
			ptst.setInt(4, vo.getQtdPaginas());
			ptst.setInt(5, vo.getQtdExemplares());
			ptst.setDouble(6, vo.getValorAluguel());
			ptst.setInt(7, vo.getId());
			ptst.executeUpdate();
			
			System.out.println("Livro alterado!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public List<LivrosVO> pesquisar(LivrosVO vo) {
		conn = getConnection();
		PreparedStatement ptst;
		ResultSet rs;
		
		Calendar dataCalendar = Calendar.getInstance();
		
		List<LivrosVO> livros = new ArrayList<LivrosVO>();
		try {
			//pesquisa por titulo
			if(vo.getTitulo() != null) {
				String sql = "SELECT * FROM livros WHERE titulo ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getTitulo() + "%");
				rs = ptst.executeQuery();
				
				while(rs.next()) {
					LivrosVO livro = new LivrosVO();
					//adicionando o resultado ao objeto livro
					livro.setId(rs.getInt("id_livro"));
					livro.setTitulo(rs.getString("titulo"));
					livro.setGenero(rs.getString("genero"));
					dataCalendar.set(Calendar.YEAR, rs.getInt("ano_lancamento"));
					livro.setAnoLancamento(dataCalendar);
					livro.setQtdPaginas(rs.getInt("qtd_paginas"));
					livro.setQtdExemplares(rs.getInt("qtd_exemplares"));
					livro.setValorAluguel(rs.getDouble("valor_aluguel"));
					
					livros.add(livro);
				}
			
			}
			//pesquisa por genero
			else if(vo.getGenero() != null) {
				String sql = "SELECT * FROM livros WHERE genero ILIKE ?";
				ptst = conn.prepareStatement(sql);
				ptst.setString(1, "%" + vo.getGenero() + "%");
				rs = ptst.executeQuery();
				
				while(rs.next()) {
					LivrosVO livro = new LivrosVO();
					//adicionando o resultado ao objeto livro
					livro.setId(rs.getInt("id_livro"));
					livro.setTitulo(rs.getString("titulo"));
					livro.setGenero(rs.getString("genero"));
					dataCalendar.set(Calendar.YEAR, rs.getInt("ano_lancamento"));
					livro.setAnoLancamento(dataCalendar);
					livro.setQtdPaginas(rs.getInt("qtd_paginas"));
					livro.setQtdExemplares(rs.getInt("qtd_exemplares"));
					livro.setValorAluguel(rs.getDouble("valor_aluguel"));
					
					livros.add(livro);
				}
			}
			//pesquisa por ano de lançamento
			else if(vo.getAnoLancamento() != null) {
				int ano = vo.getAnoLancamento().getWeekYear();
				String sql = "SELECT * FROM livros WHERE ano_lancamento = ?";
				ptst = conn.prepareStatement(sql);
				ptst.setInt(1, ano);
				rs = ptst.executeQuery();
				
				while(rs.next()) {
					LivrosVO livro = new LivrosVO();
					//adicionando o resultado ao objeto livro
					livro.setId(rs.getInt("id_livro"));
					livro.setTitulo(rs.getString("titulo"));
					livro.setGenero(rs.getString("genero"));
					dataCalendar.set(Calendar.YEAR, rs.getInt("ano_lancamento"));
					livro.setAnoLancamento(dataCalendar);
					livro.setQtdPaginas(rs.getInt("qtd_paginas"));
					livro.setQtdExemplares(rs.getInt("qtd_exemplares"));
					livro.setValorAluguel(rs.getDouble("valor_aluguel"));
					
					livros.add(livro);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Livro pesquisado!");
		return livros;
	}
	
	//listar todos os livros
	public List<LivrosVO> listar() {
		conn = getConnection();
		String sql = "SELECT * FROM livros";
		Statement st;
		ResultSet rs;
		List<LivrosVO> livros = new ArrayList<LivrosVO>();
		
		Calendar dataCalendar = Calendar.getInstance();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				LivrosVO vo = new LivrosVO();
				vo.setId(rs.getInt("id_livro"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setGenero(rs.getString("genero"));
				dataCalendar.set(Calendar.YEAR, rs.getInt("ano_lancamento"));
				vo.setAnoLancamento(dataCalendar);
				vo.setQtdPaginas(rs.getInt("qtd_paginas"));
				vo.setQtdExemplares(rs.getInt("qtd_exemplares"));
				vo.setValorAluguel(rs.getDouble("valor_aluguel"));
				livros.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Livros listados!");
		return livros;
	}
}
