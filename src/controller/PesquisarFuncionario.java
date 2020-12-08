package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.VO.ClientesVO;
import model.VO.FuncionariosVO;
import view.Telas;

public class PesquisarFuncionario {
	
	@FXML private TextField id;
	@FXML private TextField login;
	@FXML private TableView<FuncionariosVO> tabelafuncionarios;
	@FXML private Pane painelConteudo;
	
	
	public void Initialize()
	{
		TableColumn<FuncionariosVO, String> colunaId = new TableColumn<>("ID");
		TableColumn<FuncionariosVO, String> colunaCpf = new TableColumn<>("CPF");
		TableColumn<FuncionariosVO, String> colunaEndereco = new TableColumn<>("endereço");
		TableColumn<FuncionariosVO, String> colunaNome = new TableColumn<>("nome");
		TableColumn<FuncionariosVO, String> colunaLogin = new TableColumn<>("login");
		TableColumn<FuncionariosVO, String> colunaSenha = new TableColumn<>("senha");
		TableColumn<FuncionariosVO, String> colunaCargo = new TableColumn<>("cargo");
		
		
		tabelafuncionarios.getColumns().addAll(colunaId, colunaCpf,colunaEndereco, colunaNome, colunaLogin, colunaSenha, colunaCargo);
	}
	
	public void telaPesquisarFuncionario(ActionEvent event) throws Exception {
		Telas.telaPesquisaFuncionario(painelConteudo);
	}
}
