package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.PessoasBO;
import model.VO.AlugueisVO;
import model.VO.FuncionariosVO;

public class ExFuncionarios {
	
	@FXML private TableView tabelaexfuncionarios;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	PessoasBO<FuncionariosVO> bo = new PessoasBO<FuncionariosVO>();
	ObservableList<FuncionariosVO> lista;
	
	@FXML
	 void initialize(){
		TableColumn<FuncionariosVO, String> colunaId = new TableColumn<>("ID");
		TableColumn<FuncionariosVO, String> colunaCpf = new TableColumn<>("CPF");
		TableColumn<FuncionariosVO, String> colunaNome = new TableColumn<>("nome");
		TableColumn<FuncionariosVO, String> colunaLogin = new TableColumn<>("login");
		TableColumn<FuncionariosVO, String> colunaSenha = new TableColumn<>("senha");
		TableColumn<FuncionariosVO, String> colunaCargo = new TableColumn<>("cargo");
		TableColumn<FuncionariosVO, String> colunaEndereco = new TableColumn<>("endereço");
		TableColumn<AlugueisVO, Calendar> colunaDemissao = new TableColumn<>("Data demissão");
		//TableColumn<FuncionariosVO, FuncionariosVO> colunaEditar = new TableColumn<>("");
		//TableColumn<FuncionariosVO, FuncionariosVO> colunaDeletar = new TableColumn<>("");
		
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
		colunaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		colunaCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		colunaDemissao.setCellValueFactory(new PropertyValueFactory<>("data_demissao"));
		colunaDemissao.setCellFactory( cell -> {          
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
		
		tabelaexfuncionarios.getColumns().addAll(colunaId, colunaCpf, colunaNome, colunaLogin, colunaSenha, colunaCargo, colunaEndereco, colunaDemissao);
		lista = FXCollections.observableArrayList(bo.ListarExFuncionarios());
		tabelaexfuncionarios.setItems(lista);
		
		
	}
}
