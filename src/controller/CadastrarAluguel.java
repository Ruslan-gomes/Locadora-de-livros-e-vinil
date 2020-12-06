package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import view.Telas;

public class CadastrarAluguel {
	
	@FXML private TextField nomecliente;
	@FXML private TextField nomeproduto;
	@FXML private TextField quantidadealugada;
	@FXML private TextField dataemprestimo;
	@FXML private TextField valortotal;
	@FXML private Pane painelConteudo;
	public void telaCadastrarAluguel(ActionEvent event) throws Exception {
		Telas.telaCadastraAluguel(painelConteudo);
	}
	
}
