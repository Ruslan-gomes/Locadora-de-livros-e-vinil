package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.BO.PessoasBO;
import model.VO.FuncionariosVO;

public class EditarFuncionario {
	public static EditarFuncionario editarFuncionario;
	
	@FXML private TextField cpf;
	@FXML private TextField nome;
	@FXML private TextField endereco;
	@FXML private TextField login;
	@FXML private TextField senha;
	@FXML private TextField cargo;
	@FXML private Pane painelConteudo;
	
	PessoasBO<FuncionariosVO> bo = new PessoasBO<FuncionariosVO>();
	Long id;
	
	@FXML
	void initialize() {
		//cpfcliente.setText("123");
		editarFuncionario = this;
	}
	
	
	public void editarFunionario(ActionEvent event) throws Exception
	{
		FuncionariosVO func = new FuncionariosVO();
		func.setId(id);
		func.setCpf(cpf.getText());
		func.setNome(nome.getText());
		func.setEndereco(endereco.getText());
		func.setLogin(login.getText());
		func.setSenha(senha.getText());
		func.setCargo(cargo.getText());
		
		bo.editarPessoa(func);
	}
	
	public void insereTexto(FuncionariosVO func)
	{
		id = func.getId();
		cpf.setText(func.getCpf());
		nome.setText(func.getNome());
		endereco.setText(func.getEndereco());
		login.setText(func.getLogin());
		senha.setText(func.getSenha());
		cargo.setText(func.getCargo());
	}
}
