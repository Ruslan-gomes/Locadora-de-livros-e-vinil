package model.BO;

import java.sql.SQLException;
import java.util.List;

import model.VO.ProdutosVO;

public interface ProdutosInterBO<VO> {
	
	public void cadastrarProduto(VO vo) throws SQLException;
	public void deletarProduto(ProdutosVO produto);
	public void editarProduto(ProdutosVO produto);
	public List<VO> pesquisarProduto(VO vo);
	public List<VO> listarProduto(VO vo);
}
