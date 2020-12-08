package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.VO.LivrosVO;

public class PesquisarLivro {
	
	@FXML private TextField titulo;
	@FXML private TextField genero;
	@FXML private TextField anolancamento;
	@FXML private TableView<LivrosVO> tabelalivros;
}
