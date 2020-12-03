package model.BO;

import model.VO.ProdutosVO;

public interface ProdutosInterBO<VO> {
	
	public void cadastrarProduto(VO vo);
	public void deletarProduto(ProdutosVO produto);
	public void editarProduto(ProdutosVO produto);
	public void pesquisarProduto(VO vo);
	public void listarProduto(VO vo);
}
