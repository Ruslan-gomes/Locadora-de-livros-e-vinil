package model.DAO;

import java.sql.ResultSet;

import model.VO.LivrosVO;

public interface LivrosInterDAO {
	public void cadastrar(LivrosVO vo);
	public void deletar(LivrosVO vo);
	public void editar(LivrosVO vo);
	public ResultSet pesquisar(LivrosVO vo);
	public ResultSet listar();
}
