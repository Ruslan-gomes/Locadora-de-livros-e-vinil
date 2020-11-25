package model.BO;

import model.VO.ProdutosVO;

public interface ProdutosInterBO {
	
	public void cadastrarProduto(ProdutosVO produto);
	public void deletarProduto(ProdutosVO produto);
	public void editarProduto(ProdutosVO produto);
	public void pesquisarProduto(ProdutosVO produto);
}
