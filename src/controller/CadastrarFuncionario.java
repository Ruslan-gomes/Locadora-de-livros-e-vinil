package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class CadastrarFuncionario {
	
@FXML private Pane painelConteudo;
	
	public void telaCadastrarFuncionario(ActionEvent event) throws Exception {
		Telas.telaCadastraFuncionario(painelConteudo);
	}
}
