package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.PessoasBO;
import model.VO.ClientesVO;
import view.Telas;

public class EditarCliente {
	public static EditarCliente editarCliente;
	
	@FXML private Pane painel;
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private Pane painelConteudo;
	
	
	PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
	
	@FXML
	void initialize() {
		//cpfcliente.setText("123");
		editarCliente = this;
	}
	
	public void editarCliente(ActionEvent event) throws Exception
	{
		ClientesVO cliente = new ClientesVO();
		cliente.setCpf(cpf.getText());
		cliente.setNome(nome.getText());
		cliente.setEndereco(endereco.getText());
		
		bo.editarPessoa(cliente);
		
		//fecha a tela
		Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		PesquisarCliente.pesquisarCliente.atualizaTableView();
		stage.close();
	}
	
	public void insereTexto(ClientesVO cliente)
	{
		cpf.setText(cliente.getCpf());
		nome.setText(cliente.getNome());
		endereco.setText(cliente.getEndereco());
	}
}
