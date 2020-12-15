package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.PessoasBO;
import model.VO.FuncionariosVO;
import view.Telas;

public class EditarFuncionario {
	public static EditarFuncionario editarFuncionario;
	
	@FXML private Pane painel;
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
		editarFuncionario = this;
	}
	
	
	public void editarFuncionario(ActionEvent event) throws Exception
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
		
		//fecha a tela
		Stage stage = (Stage) painel.getScene().getWindow();
		
		//Abre a POP-UP confirmando a edição
		Telas.telaCadastroEfetuado();
		ConfirmarCadastro.confirmarCadastro.alteraTexto("Editado com sucesso!");
		
		PesquisarFuncionario.pesquisarFuncionario.atualizaTableView();
		stage.close();
		
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
