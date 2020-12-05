package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class ListarClientes {
	
	@FXML private Pane painelConteudo;
	
	public void telaListarClientes(ActionEvent event) throws Exception {
		Telas.telaListaClientes(painelConteudo);
	}
}
