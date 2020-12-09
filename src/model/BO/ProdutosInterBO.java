package model.BO;

import java.sql.SQLException;

import model.VO.ProdutosVO;

public interface ProdutosInterBO<VO> {
	
	public void cadastrarProduto(VO vo) throws SQLException;
	public void deletarProduto(ProdutosVO produto);
	public void editarProduto(ProdutosVO produto);
	public void pesquisarProduto(VO vo);
	public void listarProduto(VO vo);
}
