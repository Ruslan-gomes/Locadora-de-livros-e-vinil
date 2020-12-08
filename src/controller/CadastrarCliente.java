package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
import model.BO.PessoasBO;
import model.VO.ClientesVO;
//import view.Telas;

public class CadastrarCliente {
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TextField endereco;
	
	PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
	
	public void cadastrarCliente(ActionEvent event) throws Exception
	{
		ClientesVO cliente  = new ClientesVO();
		cliente.setCpf(cpf.getText());
		cliente.setNome(nome.getText());
		cliente.setEndereco(endereco.getText());
		
		bo.cadastrarPessoa(cliente);
	}
}
