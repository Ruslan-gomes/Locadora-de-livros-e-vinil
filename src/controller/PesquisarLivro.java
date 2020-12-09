package controller;

import java.sql.Date;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ProdutosBO;
import model.VO.LivrosVO;

public class PesquisarLivro {
	
	@FXML private TextField titulo;
	@FXML private TextField genero;
	@FXML private TextField anolancamento;
	@FXML private TableView<LivrosVO> tabelalivros;
	
	ProdutosBO<LivrosVO> bo = new ProdutosBO<LivrosVO>();
	ObservableList<LivrosVO> lista;
	
	@FXML
	void initialize()
	{
		LivrosVO vo = new LivrosVO();
		
		TableColumn<LivrosVO, String> colunaTitulo = new TableColumn<>("Título");
		TableColumn<LivrosVO, String> colunaGenero = new TableColumn<>("Gênero");
		TableColumn<LivrosVO, String> colunaAnoLancamento = new TableColumn<>("Ano de lançamento");
		TableColumn<LivrosVO, String> colunaPaginas = new TableColumn<>("Qtd páginas");
		TableColumn<LivrosVO, String> colunaExemplares = new TableColumn<>("qtde exemplares");
		TableColumn<LivrosVO, Double> colunaValorAluguel = new TableColumn<>("Valor aluguel");
		
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
		colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
		colunaPaginas.setCellValueFactory(new PropertyValueFactory<>("qtdPaginas"));
		colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("qtdExemplares"));
		colunaValorAluguel.setCellValueFactory(new PropertyValueFactory<>("valorAluguel"));
		
		tabelalivros.getColumns().addAll(colunaTitulo, colunaGenero, colunaAnoLancamento, colunaPaginas, colunaExemplares, colunaValorAluguel);
		
		lista = FXCollections.observableArrayList(bo.listarProduto(vo));
		tabelalivros.setItems(lista);
	}
	
	
	public void pesquisarLivro(ActionEvent event) throws Exception
	{
		LivrosVO vo = new LivrosVO();
		if(titulo.getText() != null && !titulo.getText().isEmpty())
		{
			vo.setTitulo(titulo.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabelalivros.setItems(lista);
			titulo.setText("");
		}
		else if(genero.getText() != null && !genero.getText().isEmpty())
		{
			vo.setGenero(genero.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabelalivros.setItems(lista);
			genero.setText("");
		}
		else if(anolancamento.getText() != null && !anolancamento.getText().isEmpty())
		{
			Calendar data = Calendar.getInstance();
			data.setTime(Date.valueOf(anolancamento.getText()));
			vo.setAnoLancamento(data);
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabelalivros.setItems(lista);
			anolancamento.setText("");
		}
	}
}
