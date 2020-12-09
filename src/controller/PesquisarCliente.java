package controller;

import java.util.ArrayList;
import java.util.List;

//import entites.Person;
//import gui.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import model.BO.PessoasBO;
import model.VO.ClientesVO;
import view.Telas;


public class PesquisarCliente {
	
	@FXML private TextField cpf;
	@FXML private TableView<ClientesVO> tabelaclientes;
	@FXML private Pane painelConteudo;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	@FXML
	void initialize(){
		
		TableColumn<ClientesVO, String> colunaCpf = new TableColumn<>("CPF");
		TableColumn<ClientesVO, String> colunaNome = new TableColumn<>("Nome");
		TableColumn<ClientesVO, String> colunaEndereco = new TableColumn<>("Endereço");
		TableColumn<ClientesVO, ClientesVO> colunaEditar = new TableColumn<>("");
		TableColumn<ClientesVO, ClientesVO> colunaDeletar = new TableColumn<>("");
		
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        //colunaAcao.setCellValueFactory(new PropertyValueFactory<>("editar"));
		
        tabelaclientes.getColumns().addAll(colunaCpf, colunaNome, colunaEndereco, colunaEditar, colunaDeletar);
        
        ClientesVO cliente = new ClientesVO();
        cliente.setCpf("11122233345");
        cliente.setNome("Edmundo");
        cliente.setEndereco("Rua tal");
        
        PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
        System.out.println(bo.ListarPessoa(cliente));
        
        
        List<ClientesVO> arrayClientes = bo.ListarPessoa(cliente);
        ObservableList<ClientesVO> listaClientes = FXCollections.observableArrayList(arrayClientes);
		tabelaclientes.setItems(listaClientes);
		
		// BOTÕES COM ÍCONES EM SVG
		// configura a coluna para editar e deleter uma pessoa
		Utils.initButtons(colunaEditar, 15, PEN_SOLID, "svg-gray", (ClientesVO ClientesVO, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + ClientesVO.getNome());
			// Aqui vai toda a lógica para editar a pessoa
		});
		Utils.initButtons(colunaDeletar, 15, TRASH_SOLID, "svg-red", (ClientesVO ClientesVO, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: "+ ClientesVO.getNome());
			// Aqui vai toda a lógica para deletar a pessoa
		});
	}
	
}
