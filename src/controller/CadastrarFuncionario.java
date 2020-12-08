package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
	@FXML private Pane painelConteudo;
	
	PessoasBO<FuncionariosVO> bo = new PessoasBO<FuncionariosVO>();
	
	public void telaCadastrarFuncionario(ActionEvent event) throws Exception {
		Telas.telaCadastraFuncionario(painelConteudo);
	}
	
	public void cadastrarFuncionario(ActionEvent event) throws Exception
	{
		
	}
}
