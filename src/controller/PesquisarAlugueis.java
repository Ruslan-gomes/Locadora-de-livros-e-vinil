package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Calendar;
import java.util.Date;

//import java.util.ArrayList;
//import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
//import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
//import javafx.util.Callback;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;
import view.Telas;

public class PesquisarAlugueis {
	public static PesquisarAlugueis pesquisarAlugueis;
	@FXML Pane painelConteudo;
	@FXML private TextField cpfcliente;
	@FXML private TableView<AlugueisVO> tabelaalugueis;
	@FXML private Button btnDeletar;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	AlugueisBO bo = new AlugueisBO();
	ObservableList<AlugueisVO> lista;
	
	@FXML
	 void initialize()
	{
		pesquisarAlugueis = this;
		TableColumn<AlugueisVO, String> cpfCliente = new TableColumn<>("cpf_cliente");
		TableColumn<AlugueisVO, String> nomeProduto = new TableColumn<>("nome_produto");
		TableColumn<AlugueisVO, String> quantidade = new TableColumn<>("quantidade");
		TableColumn<AlugueisVO, Calendar> dataEmprestimo = new TableColumn<>("Data emprestimo");
		TableColumn<AlugueisVO, Calendar> dataDevolucao = new TableColumn<>("Data devolucao");
		TableColumn<AlugueisVO, String> valorTotal = new TableColumn<>("Valor");
		TableColumn<AlugueisVO, AlugueisVO> colunaEditar = new TableColumn<>("");
		TableColumn<AlugueisVO, AlugueisVO> colunaDeletar = new TableColumn<>("");
		
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
        
        tabelaalugueis.getColumns().addAll(cpfCliente, nomeProduto, quantidade, dataEmprestimo, dataDevolucao, valorTotal, colunaEditar, colunaDeletar);
        
        //System.out.println(bo.listar());
        lista = FXCollections.observableArrayList(bo.listar());
        tabelaalugueis.setItems(lista);
        
     // BOTÕES COM ÍCONES EM SVG
		// configura a coluna para editar e deletar
		Utils.initButtons(colunaEditar, 15, PEN_SOLID, "svg-gray", (AlugueisVO AlugueisVO, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + AlugueisVO.getNomeProduto());
			// Aqui vai toda a lógica para editar 
				try {
					Telas.telaEditaAlugueis();
					EditarAlugueis.editarAluguel.insereTexto(AlugueisVO);
				} catch (Exception e) {
					try {
						Telas.telaErro();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
		Utils.initButtons(colunaDeletar, 15, TRASH_SOLID, "svg-red", (AlugueisVO AlugueisVO, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: "+ AlugueisVO.getNomeProduto());
			
			// Aqui vai toda a lógica para deletar 
			try {
				Telas.telaConfirmaDelecao();
				ConfirmarDelecao.confirmarDelecao.setAluguel(AlugueisVO);
			} catch (Exception e) {
				try {
					Telas.telaErro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
	
	public void atualizaTableView() {
		tabelaalugueis.setItems(null);
		ObservableList<AlugueisVO> lista = FXCollections.observableArrayList(bo.listar());
        tabelaalugueis.setItems(lista);
	}
	
	
	public void pesquisarAluguel(ActionEvent event) throws Exception
	{
		ClientesVO cliente = new ClientesVO();
		AlugueisVO vo = new AlugueisVO();
		vo.setCliente(cliente);
		if(cpfcliente.getText() != null && !cpfcliente.getText().isEmpty())
		{
			vo.getCliente().setCpf(cpfcliente.getText());
			cpfcliente.setText("");
			lista = FXCollections.observableArrayList(bo.pesquisarAluguel(vo));
			tabelaalugueis.setItems(lista);
		}
	}
	
	public void limparPesquisa(ActionEvent event) throws Exception
	{
		this.atualizaTableView();
	}
}
