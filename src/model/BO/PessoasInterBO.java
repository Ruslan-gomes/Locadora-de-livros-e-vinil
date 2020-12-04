package model.BO;

import exception.AutenticationException;
import model.VO.FuncionariosVO;
import model.VO.PessoasVO;

public interface PessoasInterBO<VO> {
	
	public void cadastrarPessoa(VO vo);
	public void deletarPessoa(PessoasVO pessoa);
	public void editarPessoa(PessoasVO pessoa);
	public void pesquisarPessoa(VO vo);
	public void ListarPessoa(VO vo);
	public FuncionariosVO autenticar(FuncionariosVO usuario) throws AutenticationException;
}
