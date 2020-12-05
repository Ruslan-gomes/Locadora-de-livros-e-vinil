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
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/cadastroClientes.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
		
	}
	
	public static void telaPesquisaClientes(Pane painelConteudo) throws Exception{
		Pane pane = FXMLLoader.load(Telas.class.getResource("VE/pesquisaClientes.fxml"));
		
		painelConteudo.getChildren().clear();
		painelConteudo.getChildren().add(pane);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
