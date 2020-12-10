package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;
import view.Telas;

public class ConfirmarDelecao {
	public static ConfirmarDelecao confirmarDelecao;
	@FXML private Pane painel;
	
	AlugueisVO aluguel = new AlugueisVO();
	
	@FXML
    private Label labelTexto;
	
	@FXML
	void initialize() {
		confirmarDelecao = this;
	}
	
	public void setAluguel(AlugueisVO aluguelDeletar) {
		aluguel = aluguelDeletar;
	}
	
	@FXML
    void deletar() throws Exception {
		AlugueisBO bo = new AlugueisBO();
		bo.deletarAluguel(aluguel);
		
		//Abre a POP-UP confirmando a edição
		Telas.telaCadastroEfetuado();
		ConfirmarCadastro.confirmarCadastro.alteraTexto("Deletado com sucesso!");
		
		Stage stage = (Stage) painel.getScene().getWindow();
		
		//Atualiza a tableview
		PesquisarAlugueis.pesquisarAlugueis.atualizaTableView();
		
		//fecha a pop-up de confirmação de deleção
		stage.close();
    }

    @FXML
    void cancelar() {
    	Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		stage.close();
    }
	
	public void alteraTexto(String texto)  {
		labelTexto.setText(texto);
	}
}
