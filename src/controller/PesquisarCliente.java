package controller;

import java.io.IOException;
import java.util.List;

//import entites.Person;
//import gui.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.BO.PessoasBO;
import model.VO.ClientesVO;
import view.Telas;


public class PesquisarCliente {
	public static PesquisarCliente pesquisarCliente;
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TableView<ClientesVO> tabelaclientes;
	@FXML private Pane painelConteudo;
	
	
	PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
	ObservableList<ClientesVO> listaClientes;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	@FXML
	void initialize(){
		pesquisarCliente = this;
		
		TableColumn<ClientesVO, String> colunaCpf = new TableColumn<>("CPF");
		TableColumn<ClientesVO, String> colunaNome = new TableColumn<>("Nome");
		TableColumn<ClientesVO, String> colunaEndereco = new TableColumn<>("Endere�o");
		TableColumn<ClientesVO, ClientesVO> colunaEditar = new TableColumn<>("");
		TableColumn<ClientesVO, ClientesVO> colunaDeletar = new TableColumn<>("");
		
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		
        tabelaclientes.getColumns().addAll(colunaCpf, colunaNome, colunaEndereco, colunaEditar, colunaDeletar);
        
        ClientesVO cliente = new ClientesVO();
        cliente.setCpf("11122233345");
        cliente.setNome("Edmundo");
        cliente.setEndereco("Rua tal");
        
        PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
      
        List<ClientesVO> arrayClientes = bo.ListarPessoa(cliente);
        ObservableList<ClientesVO> listaClientes = FXCollections.observableArrayList(arrayClientes);
		tabelaclientes.setItems(listaClientes);
		
		// BOT�ES COM �CONES EM SVG
		// configura a coluna para editar e deletar uma pessoa
		Utils.initButtons(colunaEditar, 15, PEN_SOLID, "svg-gray", (ClientesVO ClientesVO, ActionEvent event) -> {
			try {
				Telas.telaEditaClientes();
				EditarCliente.editarCliente.insereTexto(ClientesVO);
			} catch (Exception e) {
				try {
					Telas.telaErro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Utils.initButtons(colunaDeletar, 15, TRASH_SOLID, "svg-red", (ClientesVO ClientesVO, ActionEvent event) -> {
			// Aqui vai toda a l�gica para deletar a pessoa
			try {
				Telas.telaConfirmaDelecao();
				ConfirmarDelecao.confirmarDelecao.setCliente(ClientesVO);
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
	
	
	public void pesquisarCliente(ActionEvent event) throws Exception
	{
		ClientesVO vo = new ClientesVO();
		if(cpf.getText() != null && !cpf.getText().isEmpty())
		{
			vo.setCpf(cpf.getText());
			
			listaClientes = FXCollections.observableArrayList(bo.pesquisarPessoa(vo));
			tabelaclientes.setItems(listaClientes);
			cpf.setText("");
		}
		else if(nome.getText() != null && !nome.getText().isEmpty())
		{
			vo.setNome(nome.getText());
			
			listaClientes = FXCollections.observableArrayList(bo.pesquisarPessoa(vo));
			tabelaclientes.setItems(listaClientes);
			nome.setText("");
		}
	}
	
	public void atualizaTableView() {
		ClientesVO cliente = new ClientesVO();
		tabelaclientes.setItems(null);
		listaClientes = FXCollections.observableArrayList(bo.ListarPessoa(cliente));
        tabelaclientes.setItems(listaClientes);
	}
	
	public void limparPesquisa(ActionEvent event) throws Exception
	{
		this.atualizaTableView();
	}
	
}
