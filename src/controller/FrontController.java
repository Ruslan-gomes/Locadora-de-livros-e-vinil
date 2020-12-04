package controller;


import exception.AutenticationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BO.PessoasBO;
import model.VO.FuncionariosVO;

public class FrontController {
	@FXML private Label erroAut;
	@FXML private TextField login;
	@FXML private TextField senha;
	
	PessoasBO<FuncionariosVO> usuBO = new PessoasBO<FuncionariosVO>();
	public void autenticar(ActionEvent event) {
		FuncionariosVO funcionario = new FuncionariosVO();
		funcionario.setLogin(login.getText());
		funcionario.setSenha(senha.getText());
		
		try {
			FuncionariosVO usuarioAutenticado = usuBO.autenticar(funcionario);
			System.out.println("Você está logado " + usuarioAutenticado.getNome());
			if(usuarioAutenticado.getCargo() == "Administrador") {
				//abrir janela de administrador
				
			}else if (usuarioAutenticado.getCargo() == "Recepcionista") {
				//Abrir janela de recepcionista
				
			}
		}catch(AutenticationException e) {
			erroAut.setText("Usuário ou senha inválidos!");
			erroAut.setVisible(true);
		}
		
		
	}
}
