package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import view.Telas;

public class CadastrarDevolucao {
	
	@FXML private TextField cpfcliente;
	@FXML private TextField nomeproduto;
	@FXML private TextField datadevolucao;
	@FXML private Pane painelConteudo;
	
	public void telaCadastrarDevolucao(ActionEvent event) throws Exception {
		Telas.telaCadastraDevolucao(painelConteudo);
	}
}
