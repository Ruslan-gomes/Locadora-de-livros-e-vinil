package controller;

import java.awt.Button;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.Telas;

public class MensagemErro {
	public static MensagemErro mensagemErro;
	@FXML private Pane painel;
	
	@FXML
    private Label msgErro;
	
	@FXML
	void initialize() {
		mensagemErro = this;
	}
	
	@FXML
	public void fechar() {
		Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		stage.close();
	}
	
	public void setTexto(String texto) {
		msgErro.setText(texto);
	}
}
