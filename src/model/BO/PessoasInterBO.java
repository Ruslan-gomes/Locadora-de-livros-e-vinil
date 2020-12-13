package model.BO;

import java.util.List;

import exception.AutenticationException;
import model.VO.FuncionariosVO;
import model.VO.PessoasVO;

public interface PessoasInterBO<VO> {
	
	public void cadastrarPessoa(VO vo) throws Exception;
	public void deletarPessoa(VO vo);
	public void editarPessoa(VO vo);
	public List<VO> pesquisarPessoa(VO vo);
	public List<VO> ListarPessoa(VO vo);
	public List<VO> ListarExFuncionarios();
	public FuncionariosVO autenticar(FuncionariosVO usuario) throws AutenticationException;
}
