package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import view.Telas;

public class ConfirmarDelecao {
@FXML private Pane painelConteudo;
	
	public void telaConfirmarDelecao(ActionEvent event) throws Exception {
		Telas.telaConfirmaDelecao(painelConteudo);
	}
}
