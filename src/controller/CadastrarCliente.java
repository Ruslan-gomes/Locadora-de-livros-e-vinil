package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
import model.BO.PessoasBO;
import model.VO.ClientesVO;
import view.Telas;
//import view.Telas;

public class CadastrarCliente {
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private Label mensagem;
	
	PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
	
	public void cadastrarCliente(ActionEvent event) throws Exception
	{
		
			ClientesVO cliente  = new ClientesVO();
			cliente.setCpf(cpf.getText());
			cliente.setNome(nome.getText());
			cliente.setEndereco(endereco.getText());
			
			try {
				bo.cadastrarPessoa(cliente);
				
				//limpa os campos
				cpf.setText("");
				nome.setText("");
				endereco.setText("");
				mensagem.setVisible(false);
				
				Telas.telaCadastroEfetuado();
			}catch(Exception e) {
				Telas.telaErro();
			}
	}
}
