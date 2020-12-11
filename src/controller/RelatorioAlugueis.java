package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;

public class RelatorioAlugueis{
	public static RelatorioAlugueis relatorioAlugueis;
	
	@FXML  Pane painelconteudo;
	
	@FXML private ComboBox escolha;
	@FXML private DatePicker datainicio;
	@FXML private DatePicker datafim;
	@FXML private TableView<AlugueisVO> tabelaalugueis;
	
	AlugueisBO bo = new AlugueisBO();
	ObservableList<AlugueisVO> lista;
	
	@FXML
	void initialize() 
	{
        relatorioAlugueis = this;
        
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
        dataEmprestimo.setCellFactory( cell -> {          
            return new TableCell<AlugueisVO, Calendar>() {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                
                @Override
                protected void updateItem( Calendar item, boolean empty) {
                   super.updateItem(item, empty);
                   
                   if( !empty ) {
                      setText( format.format(item.getTimeInMillis()));
                   }else {
                      setText("");
                      setGraphic(null);
                   }
                }
            };        
         } );
        dataDevolucao.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
        dataDevolucao.setCellFactory( cell -> {          
            return new TableCell<AlugueisVO, Calendar>() {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                
                @Override
                protected void updateItem( Calendar item, boolean empty) {
                   super.updateItem(item, empty);
                   
                   if( !empty ) {
                      setText( format.format(item.getTimeInMillis()));
                   }else {
                      setText("");
                      setGraphic(null);
                   }
                }
            };        
         } );
        valorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        
        tabelaalugueis.getColumns().addAll(cpfCliente, nomeProduto, quantidade, dataEmprestimo, dataDevolucao, valorTotal);
        
        //System.out.println(bo.listar());
        lista = FXCollections.observableArrayList(bo.listar());
        tabelaalugueis.setItems(lista);
    }
	
	public void pesquisarRelatorio(ActionEvent event) throws Exception
	{
		Calendar inicio = Calendar.getInstance();
		Calendar fim = Calendar.getInstance();
		
		inicio.setTime(Date.valueOf(datainicio.getValue()));
		fim.setTime(Date.valueOf(datafim.getValue()));
		
		lista = FXCollections.observableArrayList(bo.pesquisarAluguel(inicio, fim));
		tabelaalugueis.setItems(lista);
		datainicio.setValue(null);
		datafim.setValue(null);
	}
	
	public void atualizaTableView() {
		tabelaalugueis.setItems(null);
		ObservableList<AlugueisVO> lista = FXCollections.observableArrayList(bo.listar());
        tabelaalugueis.setItems(lista);
	}
	
	public void limparPesquisa(ActionEvent event) throws Exception
	{
		this.atualizaTableView();
	}
}
