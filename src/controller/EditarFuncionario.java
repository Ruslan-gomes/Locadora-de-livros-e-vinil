package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class EditarFuncionario {
	
@FXML private Pane painelConteudo;
	
	public void telaDeletarFuncionario(ActionEvent event) throws Exception {
		Telas.telaDeletaFuncionario(painelConteudo);
	}
}
