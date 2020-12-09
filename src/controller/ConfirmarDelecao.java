package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.Telas;

public class ConfirmarDelecao {
	@FXML private Pane painel;
	
	@FXML
	public void fechar() {
		Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		stage.close();
	}
}
