package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.VO.ClientesVO;
import view.Telas;


public class PesquisarCliente {
	
	@FXML private TextField cpf;
	@FXML private TableView<ClientesVO> tabelaclientes;
	@FXML private Pane painelConteudo;
	
	
	
	void Initialize()
	{
		TableColumn<ClientesVO, String> colunaCpf = new TableColumn<>("cpf");
		TableColumn<ClientesVO, String> colunaNome = new TableColumn<>("nome");
		TableColumn<ClientesVO, String> colunaEndereco = new TableColumn<>("endereço");
		
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("email"));
		
        tabelaclientes.getColumns().addAll(colunaCpf, colunaNome, colunaEndereco);
	}
}
