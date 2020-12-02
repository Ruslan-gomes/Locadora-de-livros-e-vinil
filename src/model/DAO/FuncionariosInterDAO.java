package model.DAO;

import java.util.List;

import model.VO.FuncionariosVO;

public interface FuncionariosInterDAO {
	public void Cadastrar(FuncionariosVO vo);
	public void Deletar(FuncionariosVO vo);
	public void Editar(FuncionariosVO vo);
	public FuncionariosVO Pesquisar(FuncionariosVO vo);
	public List<FuncionariosVO> Listar();
}
