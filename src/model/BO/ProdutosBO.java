package model.BO;

import model.DAO.LivrosDAO;
import model.VO.DiscosVO;
import model.VO.LivrosVO;
import model.VO.ProdutosVO;

public class ProdutosBO<VO> implements ProdutosInterBO<VO>{

	@Override
	public void cadastrarProduto(VO vo) {
		
		//Se for do tipo LivrosVO
		if(vo.getClass().getSimpleName().equals(LivrosVO.class.getSimpleName())) {
			LivrosDAO dao = new LivrosDAO();
			dao.cadastrar((LivrosVO)vo);
		}
		
		//Se for do tipo DiscosVO
		if(vo.getClass().getSimpleName().equals(DiscosVO.class.getSimpleName())) {
			System.out.println("Tipo disco, entrou!");
		}
		
		/*Se o VO for do tipo DiscosVO
		Ai chama o DiscosDAO.cadastrar*/
		
		/*Se o VO for do tipo LivrosVO
		Ai chama o LivrosDAO.cadastrar*/
		
	}

	@Override
	public void deletarProduto(ProdutosVO produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarProduto(ProdutosVO produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pesquisarProduto(ProdutosVO produto) {
		// TODO Auto-generated method stub
		
	}

}
