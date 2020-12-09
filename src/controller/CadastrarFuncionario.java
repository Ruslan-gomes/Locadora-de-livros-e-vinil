package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.BO.PessoasBO;
import model.VO.FuncionariosVO;
import view.Telas;

public class CadastrarFuncionario {
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private TextField cargo;
	
	PessoasBO<FuncionariosVO> bo = new PessoasBO<FuncionariosVO>();
	
	public void cadastrarFuncionario(ActionEvent event) throws Exception{
		FuncionariosVO funcionario  = new FuncionariosVO();
		funcionario.setCpf(cpf.getText());
		funcionario.setNome(nome.getText());
		funcionario.setEndereco(endereco.getText());
		funcionario.setLogin(login.getText());
		funcionario.setSenha(senha.getText());
		funcionario.setCargo(cargo.getText());
		
		try {
			bo.cadastrarPessoa(funcionario);
			
			cpf.setText("");
			nome.setText("");
			endereco.setText("");
			login.setText("");
			senha.setText("");
			cargo.setText("");
			System.out.println("Cadastrado!");
		}catch(Exception e) {
			Telas.telaErro();
		}
		
		
	}
}
