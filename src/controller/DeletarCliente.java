package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class DeletarCliente {
	
	@FXML private Pane painelConteudo;
	
	//@FXML private TableView<ClientesVO> tableClientes;
	public void telaDeletarClientes(ActionEvent event) throws Exception {
		Telas.telaDeletaClientes(painelConteudo);
	}

}
