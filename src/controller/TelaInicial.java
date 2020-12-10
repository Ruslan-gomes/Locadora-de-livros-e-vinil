package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import view.Telas;

public class TelaInicial {
	@FXML Pane painelConteudo;
	
	private Pane conteudo = painelConteudo;
	
	
	public Pane getConteudo() {
		return conteudo;
	}

	public void setConteudo(Pane conteudo) {
		this.conteudo = conteudo;
	}

	//--Alugueis
	public void telaCadastraAluguel(ActionEvent event) throws Exception {
		System.out.println(painelConteudo);
		Telas.telaCadastraAluguel(painelConteudo);
	}
	
	public void telaListaAlugueis(ActionEvent event) throws Exception {
		Telas.telaListaAlugueis(painelConteudo);
	}
	
	public void telaCadastraDevolucao(ActionEvent event) throws Exception {
		Telas.telaCadastraDevolucao(painelConteudo);
	}
	
	public void telaPesquisaAlugueis(ActionEvent event) throws Exception {
		Telas.telaPesquisaAlugueis(painelConteudo);
	}
	
	public void telaEditaAlugueis(ActionEvent event) throws Exception {
		Telas.telaEditaAlugueis();
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
		Telas.telaRelatorioAlugueisCliente(painelConteudo);
	}
	
	
	public void telaRelatorioFatura(ActionEvent event) throws Exception{
		Telas.telaRelatorioFatura(painelConteudo);
	}
	/*
	public void escolhaTipoRelatorio(ActionEvent event) throws Exception {
		System.out.println("Entrou na condição");
		if(escolha.getValue().equalsIgnoreCase("Todos")) {
			System.out.println(painelConteudo);
			Telas.telaRelatorioAlugueis(this.TelaInicial.painelConteudo);
		}else if(escolha.getValue().equalsIgnoreCase("Cliente")){
			System.out.println(painelConteudo);
			Telas.telaRelatorioAlugueisCliente(painelConteudo);
		}
	}
	*/
	public Pane pegaPainelConteudo() {
		return this.painelConteudo;
	}
	
	
	public void Deslogar(ActionEvent event) throws Exception
	{
		Telas.telaLogin();
	}
	
}
