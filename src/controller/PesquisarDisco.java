package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ProdutosBO;
import model.VO.DiscosVO;

public class PesquisarDisco {
	
	@FXML private TextField titulo;
	@FXML private TextField nomebanda;
	@FXML private TextField estilo;
	@FXML private TableView<DiscosVO> tabeladiscos;
	
	ProdutosBO<DiscosVO> bo = new ProdutosBO<DiscosVO>();
	ObservableList<DiscosVO> lista;
	
	@FXML
	void initialize()
	{
		DiscosVO vo = new DiscosVO();
		
		TableColumn<DiscosVO, String> colunaTitulo = new TableColumn<>("Título");
		TableColumn<DiscosVO, String> colunaEstilo = new TableColumn<>("Estilo");
		TableColumn<DiscosVO, String> colunaNomeBanda = new TableColumn<>("Nome da banda");
		TableColumn<DiscosVO, String> colunaExemplares = new TableColumn<>("qtde exemplares");
		TableColumn<DiscosVO, Double> colunaValorAluguel = new TableColumn<>("Valor aluguel");
		
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colunaEstilo.setCellValueFactory(new PropertyValueFactory<>("estilo"));
		colunaNomeBanda.setCellValueFactory(new PropertyValueFactory<>("nomeBanda"));
		colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("qtdExemplares"));
		colunaValorAluguel.setCellValueFactory(new PropertyValueFactory<>("valorAluguel"));
		
		tabeladiscos.getColumns().addAll(colunaTitulo, colunaEstilo, colunaNomeBanda, colunaExemplares, colunaValorAluguel);
		
		lista = FXCollections.observableArrayList(bo.listarProduto(vo));
		tabeladiscos.setItems(lista);
	}
	
	
	public void pesquisarDisco(ActionEvent event) throws Exception
	{
		DiscosVO vo = new DiscosVO();
		if(titulo.getText() != null && !titulo.getText().isEmpty())
		{
			vo.setTitulo(titulo.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabeladiscos.setItems(lista);
			titulo.setText("");
		}
		else if(nomebanda.getText() != null && !nomebanda.getText().isEmpty())
		{
			vo.setNomeBanda(nomebanda.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabeladiscos.setItems(lista);
			nomebanda.setText("");
		}
		else if(estilo.getText() != null && !estilo.getText().isEmpty())
		{
			vo.setEstilo(estilo.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabeladiscos.setItems(lista);
			estilo.setText("");
		}
	}
}
