package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.VO.AlugueisVO;

public class PesquisarAlugueis {
	
	@FXML private TextField cpfcliente;
	@FXML private TableView<AlugueisVO> tabelaalugueis;
}
