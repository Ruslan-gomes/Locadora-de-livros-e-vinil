package controller;

//import java.sql.Date;
import java.util.Calendar;

//import java.util.ArrayList;
//import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
//import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.util.Callback;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;

public class PesquisarAlugueis {
	
	@FXML private TextField cpfcliente;
	@FXML private TableView<AlugueisVO> tabelaalugueis;
	
	AlugueisBO bo = new AlugueisBO();
	
	@FXML
	 void initialize()
	{
		TableColumn<AlugueisVO, String> cpfCliente = new TableColumn<>("cpf_cliente");
		TableColumn<AlugueisVO, String> nomeProduto = new TableColumn<>("nome_produto");
		TableColumn<AlugueisVO, String> quantidade = new TableColumn<>("quantidade");
		TableColumn<AlugueisVO, Calendar> dataEmprestimo = new TableColumn<>("Data emprestimo");
		TableColumn<AlugueisVO, Calendar> dataDevolucao = new TableColumn<>("Data devolucao");
		TableColumn<AlugueisVO, String> valorTotal = new TableColumn<>("Valor");
		
		cpfCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        nomeProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        quantidade.setCellValueFactory(new PropertyValueFactory<>("qtdAlugados"));
        dataEmprestimo.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
        dataDevolucao.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
        valorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        
        tabelaalugueis.getColumns().addAll(cpfCliente, nomeProduto, quantidade, dataEmprestimo, dataDevolucao, valorTotal);
        
        ObservableList<AlugueisVO> lista = FXCollections.observableArrayList(bo.listar());
        tabelaalugueis.setItems(lista);
	}
}
