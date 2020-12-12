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
	public static Login telaLogin;
	@FXML private Label erroAut;
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private Pane painelConteudo;
	
	public static FuncionariosVO funcionarioLogado = new FuncionariosVO();
	
	public FuncionariosVO getFuncionarioLogado() {
		return funcionarioLogado;
	}
	
	PessoasBO<FuncionariosVO> usuBO = new PessoasBO<FuncionariosVO>();
	public void autenticar(ActionEvent event) throws Exception {
		FuncionariosVO funcionario = new FuncionariosVO();
		funcionario.setLogin(login.getText());
		funcionario.setSenha(senha.getText());
		
		try {
			if(funcionario.getLogin() == null || funcionario.getSenha() == null) {
				throw new AutenticationException();
			}else {
				FuncionariosVO usuarioAutenticado = usuBO.autenticar(funcionario);
				System.out.println("Você está logado " + usuarioAutenticado.getNome());
				
				if(usuarioAutenticado.getCargo().equals("Supervisor")) {
					//abrir janela de administrador
					funcionarioLogado = usuarioAutenticado;
					Telas.telaInicial();
					
				}else if (usuarioAutenticado.getCargo().equals("Recepcionista")) {
					//Abrir janela de recepcionista
					funcionarioLogado = usuarioAutenticado;
					Telas.telaInicial();
				}
			}
			
		}catch(AutenticationException e) {
			erroAut.setText("Usuário ou senha inválidos!");
			erroAut.setVisible(true);
		}
		
	}//fim autenticar
}
