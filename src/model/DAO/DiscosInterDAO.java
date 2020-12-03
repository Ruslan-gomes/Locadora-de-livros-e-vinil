package model.DAO;

import java.sql.ResultSet;

import model.VO.DiscosVO;

public interface DiscosInterDAO {
	public void cadastrar(DiscosVO vo);
	public void deletar(DiscosVO vo);
	public void editar(DiscosVO vo);
	public ResultSet pesquisar(DiscosVO vo);
	public ResultSet listar();
}
