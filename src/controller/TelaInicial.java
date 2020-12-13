package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import view.Telas;

public class TelaInicial {
	public static TelaInicial telaInicial;
	@FXML public Pane painelConteudo;
	@FXML MenuButton relatorios;
	@FXML MenuItem exfunc;
	@FXML private Label funcionario;
	
	@FXML
	void initialize() {
		telaInicial = this;
		try {
			telaLogo();
			funcionario.setText(Login.funcionarioLogado.getNome());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Restricao()
	{
		relatorios.setVisible(false);
		exfunc.setVisible(false);
	}
	
	public Pane getPainelConteudo() {
		return painelConteudo;
	}

	public void setPainelConteudo(Pane conteudo) {
		painelConteudo = conteudo;
	}
	
	public void telaLogo() throws IOException {
		Telas.telaLogo(painelConteudo);
	}
	
	@FXML
    void inicio(ActionEvent event) throws IOException {
		Telas.telaLogo(painelConteudo);
    }
	
	
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
	
	public void telaExFuncionarios(ActionEvent event) throws Exception
	{
		Telas.telaExFuncionarios(painelConteudo);
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
	
	
	public void Deslogar(ActionEvent event) throws Exception
	{
		Telas.telaLogin();
	}
	
}
