package model.DAO;

import java.sql.ResultSet;

import model.VO.FuncionariosVO;

public interface FuncionariosInterDAO {
	public void Cadastrar(FuncionariosVO vo);
	public void Deletar(FuncionariosVO vo);
	public void Editar(FuncionariosVO vo);
	public ResultSet Pesquisar(FuncionariosVO vo);
	public ResultSet Listar();
	public ResultSet ListarExFuncionarios();
}
