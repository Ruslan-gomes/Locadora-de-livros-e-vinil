package view;

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
	
	public static void telaCadastrarClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastar cliente.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
		
	}
	
	public static void telaPesquisaClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar cliente.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaEditaClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/editar cliente.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaDeletaClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/deletar cliente.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaListaClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/listar clientes.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	//funcionário
	
	public static void telaCadastraFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar funcionario.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaDeletaFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/deletar funcionario.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaEditaFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/editar funcionario.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaListaFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/listar funcionarios.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaPesquisaFuncionario(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisar funcionario.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	//POP-UP de confirmação de deleção.
	
	public static void telaConfirmaDelecao(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/confirmar delecao.fxml"));
	
		painelConteudo.getChildren().add(pane);
	}
	
	//Aluguel
	
	public static void telaCadastraAluguel(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar aluguel.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaCadastraDevolucao(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastrar devolucao.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void telaListaAlugueis(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/listar alugueis.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
