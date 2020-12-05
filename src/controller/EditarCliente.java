package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class EditarCliente {
	
	@FXML private Pane painelConteudo;
	
	public void telaEditaClientes(ActionEvent event) throws Exception {
		Telas.telaEditaClientes(painelConteudo);
	}
}
