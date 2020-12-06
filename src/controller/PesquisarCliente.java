package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import view.Telas;


public class PesquisarCliente {
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private Pane painelConteudo;
	
	//@FXML private TableView<ClientesVO> tableClientes;
	public void telaPesquisaClientes(ActionEvent event) throws Exception {
		Telas.telaPesquisaClientes(painelConteudo);
	}
}
