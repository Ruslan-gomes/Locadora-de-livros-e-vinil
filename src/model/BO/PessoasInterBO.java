package model.BO;

import model.VO.PessoasVO;

public interface PessoasInterBO {
	
	public void cadastrarPessoa(PessoasVO pessoa);
	public void deletarPessoa(PessoasVO pessoa);
	public void editarPessoa(PessoasVO pessoa);
	public void pesquisarPessoa(PessoasVO pessoa);
}
