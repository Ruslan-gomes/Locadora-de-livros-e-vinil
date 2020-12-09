package controller;

import java.io.IOException;
import java.sql.SQLException;

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
	
	public void cadastrarFuncionario(ActionEvent event) throws SQLException, IOException{
		FuncionariosVO funcionario  = new FuncionariosVO();
		funcionario.setCpf(cpf.getText());
		funcionario.setNome(nome.getText());
		funcionario.setEndereco(endereco.getText());
		funcionario.setLogin(login.getText());
		funcionario.setSenha(senha.getText());
		funcionario.setCargo(cargo.getText());
		
		try {
			bo.cadastrarPessoa(funcionario);
			
			//Limpa os campos
			cpf.setText("");
			nome.setText("");
			endereco.setText("");
			login.setText("");
			senha.setText("");
			cargo.setText("");
			
			Telas.telaCadastroEfetuado();
		}catch(Exception sql) {
				Telas.telaErro();
		}
		
		
	}
}
