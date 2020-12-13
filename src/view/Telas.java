package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Locadora de livros e vinil");
		primaryStage.show();
		telaLogin();
		
	}
	
	
	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/login.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}

	public static void telaInicial() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/telaInicial.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
	}
	
	public static void telaLogo(Pane painelConteudo) throws IOException{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/logo.fxml"));
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
//--Alugueis
	public static void telaCadastraAluguel(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar aluguel.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaListaAlugueis(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/listar alugueis.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaCadastraDevolucao(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar devolucao.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaPesquisaAlugueis(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar alugueis.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaEditaAlugueis() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/editar alugueis.fxml"));
		
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));//Volta a opacidade para o normal caso a tela seja fechada com o botão de fechar do SO
		
		stage.setScene(cena);
		stage.setTitle("Edição de aluguéis");
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
	
//---Clientes
	public static void telaCadastrarClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar cliente.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
		
	}
	
	public static void telaPesquisaClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar cliente.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaEditaClientes() throws Exception{
		Pane root = FXMLLoader.load(Telas.class.getResource("VE/editar cliente.fxml"));
		
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));//Volta a opacidade para o normal caso a tela seja fechada com o botão de fechar do SO
		
		stage.setScene(cena);
		stage.setTitle("Edição de Clientes");
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
//--Funcionários
	public static void telaCadastraFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar funcionario.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaPesquisaFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar funcionario.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}

	public static void telaEditaFuncionario() throws Exception{
		Pane root = FXMLLoader.load(Telas.class.getResource("VE/editar funcionario.fxml"));
		
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));//Volta a opacidade para o normal caso a tela seja fechada com o botão de fechar do SO
		
		stage.setScene(cena);
		stage.setTitle("Edição de Funcionários");
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
	
//--Livros
	public static void telaCadastraLivro(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar livro.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaPesquisaLivro(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar livro.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaEditaLivro() throws Exception{
		Pane root = FXMLLoader.load(Telas.class.getResource("VE/editar livro.fxml"));
		
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));//Volta a opacidade para o normal caso a tela seja fechada com o botão de fechar do SO
		
		stage.setScene(cena);
		stage.setTitle("Edição de Funcionários");
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	

//--Discos
	public static void telaCadastraDisco(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar disco.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaPesquisaDisco(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar disco.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaEditaDisco() throws Exception{
		Pane root = FXMLLoader.load(Telas.class.getResource("VE/editar disco.fxml"));
		
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));//Volta a opacidade para o normal caso a tela seja fechada com o botão de fechar do SO
		
		stage.setScene(cena);
		stage.setTitle("Edição de Funcionários");
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
//--Relatórios
	public static void telaRelatorioAlugueis(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/relatorio de alugueis todos.fxml"));
	
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
		
	}
	
	public static void telaRelatorioAlugueisCliente(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/relatorio de alugueis cliente.fxml"));

		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	
	public static void telaRelatorioFatura(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/relatorio fatura.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}

//--POP-UPs
	public static void telaErro() throws IOException {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/mensagem erro.fxml"));
	
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(cena);
		stage.setTitle("Erro");
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
	
	//POP-UP de confirmação de deleção.
	
	public static void telaConfirmaDelecao() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/confirmar delecao.fxml"));
		
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(cena);
		stage.setTitle("Deleção");
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
	//POP-UP de efetuação de cadastro
	public static void telaCadastroEfetuado() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/cadastro feito.fxml"));
	
		Scene cena = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(cena);
		stage.setTitle("Sucesso!");
		stage.setOnCloseRequest(event -> primaryStage.setOpacity(1));
		
		primaryStage.setOpacity(0);//para ficar somente a tela de pop-up
		stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch();
	}
}
