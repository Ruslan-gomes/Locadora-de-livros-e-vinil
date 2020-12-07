package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import view.Telas;

public class TelaInicial {
	@FXML public Pane painelConteudo;

	
	//--Alugueis
	public void telaCadastraAluguel(ActionEvent event) throws Exception {
		Telas.telaCadastraAluguel(painelConteudo);
	}
	
	public void telaListaAlugueis(ActionEvent event) throws Exception {
		Telas.telaListaAlugueis(painelConteudo);
	}
	
	public void telaCadastraDevolucao(ActionEvent event) throws Exception {
		Telas.telaCadastraDevolucao(painelConteudo);
	}
	
	
//--Clientes
	public void telaCadastrarClientes(ActionEvent event) throws Exception {
		Telas.telaCadastrarClientes(painelConteudo);
	}
	
	public void telaPesquisaClientes(ActionEvent event) throws Exception {
		Telas.telaPesquisaClientes(painelConteudo);
	}
	
	
//--Funcionarios
	public void telaCadastraFuncionario(ActionEvent event) throws Exception {
		Telas.telaCadastraFuncionario(painelConteudo);
	}
	
	public void telaPesquisaFuncionario(ActionEvent event) throws Exception {
		Telas.telaPesquisaFuncionario(painelConteudo);
	}
	
	
//--Livros
	public void telaCadastraLivro(ActionEvent event) throws Exception {
		Telas.telaCadastraLivro(painelConteudo);
	}
	
	public void telaPesquisaLivro(ActionEvent event) throws Exception {
		Telas.telaPesquisaLivro(painelConteudo);
	}
	
//--Discos
	public void telaCadastraDisco(ActionEvent event) throws Exception {
		Telas.telaCadastraDisco(painelConteudo);
	}
	
	public void telaPesquisaDisco(ActionEvent event) throws Exception {
		Telas.telaPesquisaDisco(painelConteudo);
	}

//--Relatórios
	
	public void telaRelatorioAlugueis(ActionEvent event) throws Exception {
		Telas.telaRelatorioAlugueis(painelConteudo);
	}
	
	
	public void telaRelatorioAlugueisCliente(ActionEvent event) throws Exception {
		//Telas.telaRelatorioAlugueisCliente(painelConteudo);
		/*Pane pane = FXMLLoader.load(Telas.class.getResource("VE/relatorio de alugueis cliente.fxml"));
		System.out.println(pane);
		System.out.println(painelConteudo);
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);*/
	}
	

	
	public Pane pegaPainelConteudo() {
		return painelConteudo;
	}
	
}
