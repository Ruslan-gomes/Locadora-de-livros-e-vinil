package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.AlugueisBO;
import model.BO.PessoasBO;
import model.VO.AlugueisVO;
import model.VO.FuncionariosVO;
import view.Telas;

public class ConfirmarDelecao {
	public static ConfirmarDelecao confirmarDelecao;
	@FXML private Pane painel;
	
	AlugueisVO aluguel = new AlugueisVO();
	FuncionariosVO funcionario = new FuncionariosVO();
	
	@FXML
    private Label labelTexto;
	
	@FXML
	void initialize() {
		confirmarDelecao = this;
	}
	
	public void setAluguel(AlugueisVO aluguelDeletar) {
		aluguel = aluguelDeletar;
		funcionario = null;
	}
	
	public void setFuncionario(FuncionariosVO funcionarioDeletar) {
		aluguel = null;
		funcionario = funcionarioDeletar;
	}
	
	
	@FXML
    void deletar() throws Exception {
	//Deleção de aluguel
		if(aluguel != null) {
			AlugueisBO bo = new AlugueisBO();
			bo.deletarAluguel(aluguel);
			
			//Abre a POP-UP confirmando a deleção
			Telas.telaCadastroEfetuado();
			ConfirmarCadastro.confirmarCadastro.alteraTexto("Deletado com sucesso!");
			
			Stage stage = (Stage) painel.getScene().getWindow();
			
			//Atualiza a tableview
			PesquisarAlugueis.pesquisarAlugueis.atualizaTableView();
			
			//fecha a pop-up de confirmação de deleção
			stage.close();
		}
	//Deleção de funcionário
		else if(funcionario != null) {
			PessoasBO<FuncionariosVO> bo = new PessoasBO<FuncionariosVO>();
			bo.deletarPessoa(funcionario);
			
			Telas.telaCadastroEfetuado();
			ConfirmarCadastro.confirmarCadastro.alteraTexto("Deletado com sucesso!");
			
			Stage stage = (Stage) painel.getScene().getWindow();
			
			//Atualiza a tableview
			PesquisarFuncionario.pesquisarFuncionario.atualizaTableView();
			
			//fecha a pop-up de confirmação de deleção
			stage.close();
		}
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
