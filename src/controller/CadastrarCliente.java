package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import view.Telas;

public class CadastrarCliente {
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private Pane painelConteudo;
	
	public void telaCadastrarClientes(ActionEvent event) throws Exception {
		Telas.telaCadastrarClientes(painelConteudo);
	}
}
