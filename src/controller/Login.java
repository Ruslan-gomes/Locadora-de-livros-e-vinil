package controller;

import exception.AutenticationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.BO.PessoasBO;
import model.VO.FuncionariosVO;
import view.Telas;

public class Login {
	@FXML private Label erroAut;
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Pane painelConteudo;
	
	PessoasBO<FuncionariosVO> usuBO = new PessoasBO<FuncionariosVO>();
	public void autenticar(ActionEvent event) throws Exception {
		FuncionariosVO funcionario = new FuncionariosVO();
		funcionario.setLogin(login.getText());
		funcionario.setSenha(senha.getText());
		
		try {
			FuncionariosVO usuarioAutenticado = usuBO.autenticar(funcionario);
			System.out.println("Você está logado " + usuarioAutenticado.getNome());
			if(usuarioAutenticado.getCargo().equals("Supervisor")) {
				//abrir janela de administrador
				Telas.telaInicial();
				
			}else if (usuarioAutenticado.getCargo().equals("Recepcionista")) {
				//Abrir janela de recepcionista
				Telas.telaInicial();
			}
		}catch(AutenticationException e) {
			erroAut.setText("Usuário ou senha inválidos!");
			erroAut.setVisible(true);
		}
		
	}//fim autenticar
}
