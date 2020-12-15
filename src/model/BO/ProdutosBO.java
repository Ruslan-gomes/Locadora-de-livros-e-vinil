package model.BO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import exception.ErroCadastroAluguel;
import model.DAO.DiscosDAO;
import model.DAO.LivrosDAO;
import model.VO.DiscosVO;
import model.VO.LivrosVO;
import model.VO.ProdutosVO;

public class ProdutosBO<VO> implements ProdutosInterBO<VO>{

	@Override
	public void cadastrarProduto(VO vo) throws SQLException, ErroCadastroAluguel, IOException {
		
		if(vo instanceof LivrosVO)
		{
			if(((LivrosVO) vo).getTitulo() != null && ((LivrosVO) vo).getGenero() != null && ((LivrosVO) vo).getAnoLancamento() != null && ((LivrosVO) vo).getQtdPaginas() > 0 && ((LivrosVO) vo).getValorAluguel() > 0)
			{
				LivrosDAO dao = new LivrosDAO();
				List<VO> livroPesquisado = pesquisarProduto(vo);
				if(livroPesquisado.isEmpty()) {
					dao.cadastrar((LivrosVO)vo);
				}else throw new ErroCadastroAluguel("Livro cadastrado. Pesquise e atualize a quantidade em estoque!");
				
			}
			else
			{
				throw new SQLException();
			}
		}
		else 
		{
			if(((DiscosVO)vo).getTitulo() != null && ((DiscosVO)vo).getEstilo() != null && ((DiscosVO)vo).getNomeBanda() != null && ((DiscosVO)vo).getValorAluguel() > 0)
			{
				DiscosDAO dao = new DiscosDAO();
				List<VO> discoPesquisado = pesquisarProduto(vo);
				if(discoPesquisado.isEmpty()) {
					dao.cadastrar(((DiscosVO)vo));
				}else throw new ErroCadastroAluguel("Disco cadastrado. Pesquise e atualize a quantidade em estoque!");
			}
			else
			{
				throw new SQLException();
			}
		}
	}

	@Override
	public void deletarProduto(ProdutosVO vo) {
		if(vo instanceof LivrosVO)
		{	
			LivrosDAO dao = new LivrosDAO();
			dao.deletar((LivrosVO)vo);
		}
		else
		{
			DiscosDAO dao = new DiscosDAO();
			dao.deletar((DiscosVO)vo);
		}
	}

	@Override
	public void editarProduto(ProdutosVO vo) {
		if(vo instanceof LivrosVO)
		{
			LivrosDAO dao = new LivrosDAO();
			dao.editar((LivrosVO)vo);
		}
		else
		{
			DiscosDAO dao = new DiscosDAO();
			dao.editar((DiscosVO)vo);
		}
	}

	@Override
	public List<VO> pesquisarProduto(VO vo) {
		//Pesquisa por livro
		if(vo.getClass().getSimpleName().equals(LivrosVO.class.getSimpleName())) {
			LivrosDAO dao = new LivrosDAO();
			ResultSet rs = dao.pesquisar((LivrosVO)vo);
			
			Calendar dataCalendar = Calendar.getInstance();
			
			List<LivrosVO> livros = new ArrayList<LivrosVO>();
			try {
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
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return (List<VO>)livros;
		} //Fim Pesquisa por livro
		
		
		//Pesquisar disco
		if(vo.getClass().getSimpleName().equals(DiscosVO.class.getSimpleName())) {
			DiscosDAO dao = new DiscosDAO();
			ResultSet rs = dao.pesquisar((DiscosVO)vo);
			
			List<DiscosVO> discos = new ArrayList<DiscosVO>();
			try {
				while(rs.next()) {
					DiscosVO disco = new DiscosVO();
					//adicionando o resultado ao objeto
					disco.setId(rs.getInt("id_disco"));
					disco.setTitulo(rs.getString("titulo"));
					disco.setEstilo(rs.getString("estilo"));
					disco.setNomeBanda(rs.getString("nome_banda"));
					disco.setQtdExemplares(rs.getInt("qtd_exemplares"));
					disco.setValorAluguel(rs.getDouble("valor_aluguel"));
					
					discos.add(disco);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (List<VO>)discos;
		}//Fim pesquisar disco
		
		return null;
	}//Fim pesquisar produto
	
	public List<VO> listarProduto(VO vo) {
		//Listar todos os livros
		if(vo.getClass().getSimpleName().equals(LivrosVO.class.getSimpleName())) {
			LivrosDAO dao = new LivrosDAO();
			ResultSet rs = dao.listar();
			
			
			
			List<LivrosVO> livros = new ArrayList<LivrosVO>();
			try {
				while(rs.next()) {
					Calendar dataCalendar = Calendar.getInstance();
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
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			return (List<VO>)livros;
		}//Fim listar livros
		
		//Listar todos os discos
		if(vo.getClass().getSimpleName().equals(DiscosVO.class.getSimpleName())) {
			DiscosDAO dao = new DiscosDAO();
			ResultSet rs = dao.listar();
			
			List<DiscosVO> discos = new ArrayList<DiscosVO>();
			try {
				while(rs.next()) {
					DiscosVO disco = new DiscosVO();
					//adicionando o resultado ao objeto
					disco.setId(rs.getInt("id_disco"));
					disco.setTitulo(rs.getString("titulo"));
					disco.setEstilo(rs.getString("estilo"));
					disco.setNomeBanda(rs.getString("nome_banda"));
					disco.setQtdExemplares(rs.getInt("qtd_exemplares"));
					disco.setValorAluguel(rs.getDouble("valor_aluguel"));
					
					discos.add(disco);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return (List<VO>)discos;
		}//Fim listar discos
		return null;
	}//Fim listar produto	
}


