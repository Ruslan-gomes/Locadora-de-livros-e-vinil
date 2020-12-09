package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.VO.DiscosVO;

public class PesquisarDisco {
	
	@FXML private TextField titulo;
	@FXML private TextField nomebanda;
	@FXML private TextField estilo;
	@FXML private TableView<DiscosVO> tabeladiscos;
}