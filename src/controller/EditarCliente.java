package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.BO.PessoasBO;
import model.VO.ClientesVO;

public class EditarCliente {
	public static EditarCliente editarCliente;
	
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
	}
	
	public void insereTexto(ClientesVO cliente)
	{
		cpf.setText(cliente.getCpf());
		nome.setText(cliente.getNome());
		endereco.setText(cliente.getEndereco());
	}
}
