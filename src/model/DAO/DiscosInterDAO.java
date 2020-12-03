package model.DAO;

import java.util.List;

import model.VO.DiscosVO;

public interface DiscosInterDAO {
	public void cadastrar(DiscosVO vo);
	public void deletar(DiscosVO vo);
	public void editar(DiscosVO vo);
	public List<DiscosVO> pesquisar(DiscosVO vo);
	public List<DiscosVO> listar();
}
