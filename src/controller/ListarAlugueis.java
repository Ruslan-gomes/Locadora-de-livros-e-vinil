package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import view.Telas;

public class ListarAlugueis {
	
	@FXML private TableView tabelaalugueis;
	@FXML private Pane painelConteudo;
	
	public void telaListarAlugueis(ActionEvent event) throws Exception {
		Telas.telaCadastraDevolucao(painelConteudo);
	}
}
