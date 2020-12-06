package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class TelaInicial {
	@FXML private Pane painelConteudo;
	
	//Clientes
	public void telaCadastrarClientes(ActionEvent event) throws Exception {
		Telas.telaCadastrarClientes(painelConteudo);
	}
	
	public void telaPesquisaClientes(ActionEvent event) throws Exception {
		Telas.telaPesquisaClientes(painelConteudo);
	}
	
	
}
