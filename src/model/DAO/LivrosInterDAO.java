package model.DAO;

import java.util.List;

import model.VO.LivrosVO;

public interface LivrosInterDAO {
	public void cadastrar(LivrosVO vo);
	public void deletar(LivrosVO vo);
	public void editar(LivrosVO vo);
	public List<LivrosVO> pesquisar(LivrosVO vo);
	public List<LivrosVO> listar();
}
