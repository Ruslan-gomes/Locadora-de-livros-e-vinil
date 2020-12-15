package model.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import exception.ErroCadastroAluguel;
import model.VO.ProdutosVO;

public interface ProdutosInterBO<VO> {
	
	public void cadastrarProduto(VO vo) throws SQLException, ErroCadastroAluguel, IOException;
	public void deletarProduto(ProdutosVO produto);
	public void editarProduto(ProdutosVO produto);
	public List<VO> pesquisarProduto(VO vo);
	public List<VO> listarProduto(VO vo);
}
