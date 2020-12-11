package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.AlugueisBO;
import model.BO.PessoasBO;
import model.BO.ProdutosBO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;
import model.VO.DiscosVO;
import model.VO.LivrosVO;
import model.VO.FuncionariosVO;
import view.Telas;

public class ConfirmarDelecao {
	public static ConfirmarDelecao confirmarDelecao;
	@FXML private Pane painel;
	
	AlugueisVO aluguel = new AlugueisVO();
	FuncionariosVO funcionario = new FuncionariosVO();
	ClientesVO cliente = new ClientesVO();
	LivrosVO livro = new LivrosVO();
	DiscosVO disco = new DiscosVO();
	
	@FXML
    private Label labelTexto;
	
	@FXML
	void initialize() {
		confirmarDelecao = this;
	}
	
	public void setAluguel(AlugueisVO aluguelDeletar) {
		aluguel = aluguelDeletar;
		funcionario = null;
		cliente = null;
		livro = null;
		disco = null;
	}
	
	public void setFuncionario(FuncionariosVO funcionarioDeletar) {
		funcionario = funcionarioDeletar;
		aluguel = null;
		cliente = null;
		livro = null;
		disco = null;
	}
	
	public void setCliente(ClientesVO clienteDeletar) {
		cliente = clienteDeletar;
		aluguel = null;
		funcionario = null;
		livro = null;
		disco = null;
	}
	
	public void setLivro(LivrosVO livroDeletar) {
		livro = livroDeletar;
		aluguel = null;
		funcionario = null;
		cliente = null;
		disco = null;
	}
	
	public void setDisco(DiscosVO discoDeletar) {
		disco = discoDeletar;
		livro = null;
		aluguel = null;
		funcionario = null;
		cliente = null;
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
	//Deleção de funcionário
		else if(cliente != null) {
			PessoasBO<ClientesVO> bo = new PessoasBO<ClientesVO>();
			bo.deletarPessoa(cliente);
			
			Telas.telaCadastroEfetuado();
			ConfirmarCadastro.confirmarCadastro.alteraTexto("Deletado com sucesso!");
			
			Stage stage = (Stage) painel.getScene().getWindow();
			
			//Atualiza a tableview
			PesquisarCliente.pesquisarCliente.atualizaTableView();
			
			//fecha a pop-up de confirmação de deleção
			stage.close();
		}
	//Deleção de livros
		else if(livro != null) {
			ProdutosBO<LivrosVO> bo = new ProdutosBO<LivrosVO>();
			bo.deletarProduto(livro);
			
			Telas.telaCadastroEfetuado();
			ConfirmarCadastro.confirmarCadastro.alteraTexto("Deletado com sucesso!");
			
			Stage stage = (Stage) painel.getScene().getWindow();
			
			//Atualiza a tableview
			PesquisarLivro.pesquisarLivro.atualizaTableView();
			
			//fecha a pop-up de confirmação de deleção
			stage.close();
		}
		
	//Deleção de disco
		else if(disco != null) {
			ProdutosBO<DiscosVO> bo = new ProdutosBO<DiscosVO>();
			bo.deletarProduto(disco);
			
			Telas.telaCadastroEfetuado();
			ConfirmarCadastro.confirmarCadastro.alteraTexto("Deletado com sucesso!");
			
			Stage stage = (Stage) painel.getScene().getWindow();
			
			//Atualiza a tableview
			PesquisarDisco.pesquisarDisco.atualizaTableView();
			
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
