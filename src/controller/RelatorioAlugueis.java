package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import view.Telas;

public class RelatorioAlugueis extends TelaInicial{
	@FXML private ComboBox<String> escolha;
	//@FXML public Pane painelConteudo;
	
	
	@FXML
	void initialize(){
        System.out.println("Tela abriu!");
        ObservableList<String> opcoes = escolha.getItems();
		opcoes.addAll("Todos", "Cliente");
		escolha.setItems(opcoes);
		escolha.getSelectionModel().select(0);
    }
	
	
	public void escolhaTipoRelatorio(ActionEvent event) throws Exception {
		Pane root = FXMLLoader.load(Telas.class.getResource("VE/telaInicial.fxml"));
		Pane painel = new Pane();
		painel.setId("painelConteudo");
		
		//TelaInicial tela = new TelaInicial();
		System.out.println("Entrou na condição");
		if(escolha.getValue().equalsIgnoreCase("Todos")) {
			//System.out.println("Painel conteudo: "+ tela.pegaPainelConteudo());
			System.out.println("Controller: " + pegaPainelConteudo());
			Telas.telaRelatorioAlugueis(root);
			//tela.telaRelatorioAlugueis(event);
			
			//tela.telaRelatorioAlugueis(event);
		}else if(escolha.getValue().equalsIgnoreCase("Cliente")){
			//System.out.println("Painel conteudo: "+ tela.pegaPainelConteudo());
			System.out.println("Controller: " + pegaPainelConteudo());
			//Telas.telaRelatorioAlugueisCliente(root);
			System.out.println(event);
			//tela.telaRelatorioAlugueisCliente(event);
			
			//tela.telaRelatorioAlugueisCliente(event);
		}
	}
	
	public void montaRelatorioAlugueisTodos() {
		ObservableList<String> opcoes = FXCollections.observableArrayList("Ativo", "Suspenso");
		escolha.setItems(opcoes);
	}
}
