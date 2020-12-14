package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.Telas;

public class ConfirmarCadastro {
	public static ConfirmarCadastro confirmarCadastro;
	@FXML private Pane painel;
	
	@FXML
    private Label labelTexto;
	
	@FXML
	void initialize() {
		confirmarCadastro = this;
	}
	
	@FXML
	public void fechar() {
		Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		stage.close();
	}
	
	public void alteraTexto(String texto)  {
		labelTexto.setText(texto);
	}
}
