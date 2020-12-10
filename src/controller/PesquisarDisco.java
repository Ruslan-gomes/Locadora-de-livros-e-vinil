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
import model.VO.ClientesVO;
import model.VO.DiscosVO;

public class PesquisarDisco {
	
	@FXML private TextField titulo;
	@FXML private TextField nomebanda;
	@FXML private TextField estilo;
	@FXML private TableView<DiscosVO> tabeladiscos;
	
	ProdutosBO<DiscosVO> bo = new ProdutosBO<DiscosVO>();
	ObservableList<DiscosVO> lista;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	@FXML
	void initialize()
	{
		DiscosVO vo = new DiscosVO();
		
		TableColumn<DiscosVO, String> colunaTitulo = new TableColumn<>("Título");
		TableColumn<DiscosVO, String> colunaEstilo = new TableColumn<>("Estilo");
		TableColumn<DiscosVO, String> colunaNomeBanda = new TableColumn<>("Nome da banda");
		TableColumn<DiscosVO, String> colunaExemplares = new TableColumn<>("qtde exemplares");
		TableColumn<DiscosVO, Double> colunaValorAluguel = new TableColumn<>("Valor aluguel");
		TableColumn<DiscosVO, DiscosVO> colunaEditar = new TableColumn<>("");
		TableColumn<DiscosVO, DiscosVO> colunaDeletar = new TableColumn<>("");
		
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colunaEstilo.setCellValueFactory(new PropertyValueFactory<>("estilo"));
		colunaNomeBanda.setCellValueFactory(new PropertyValueFactory<>("nomeBanda"));
		colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("qtdExemplares"));
		colunaValorAluguel.setCellValueFactory(new PropertyValueFactory<>("valorAluguel"));
		
		tabeladiscos.getColumns().addAll(colunaTitulo, colunaEstilo, colunaNomeBanda, colunaExemplares, colunaValorAluguel, colunaEditar, colunaDeletar);
		
		lista = FXCollections.observableArrayList(bo.listarProduto(vo));
		tabeladiscos.setItems(lista);
		
		Utils.initButtons(colunaEditar, 15, PEN_SOLID, "svg-gray", (DiscosVO DiscosVO, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + DiscosVO.getTitulo());
			// Aqui vai toda a lógica para editar a pessoa
		});
		Utils.initButtons(colunaDeletar, 15, TRASH_SOLID, "svg-red", (DiscosVO DiscosVO, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: "+ DiscosVO.getTitulo());
			// Aqui vai toda a lógica para deletar a pessoa
		});
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
