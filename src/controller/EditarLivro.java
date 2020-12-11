package controller;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.ProdutosBO;
import model.VO.LivrosVO;
import view.Telas;

public class EditarLivro {
	public static EditarLivro editarLivro;
	int id;
	
	ProdutosBO<LivrosVO> bo = new ProdutosBO<LivrosVO>();
	
	@FXML private Pane painel;
	
	@FXML private TextField titulo;
	@FXML private TextField genero;
	@FXML private TextField ano;
	@FXML private TextField qtdpaginas;
	@FXML private TextField qtdexemplares;
	@FXML private TextField valoraluguel;
	
	@FXML
	void initialize()
	{
		editarLivro = this;
	}
	
	public void editarLivro(ActionEvent event) throws Exception
	{
		LivrosVO vo = new LivrosVO();
		vo.setId(id);
		vo.setTitulo(titulo.getText());
		vo.setGenero(genero.getText());
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(ano.getText()));
		vo.setAnoLancamento(cal);
		vo.setQtdPaginas(Integer.parseInt(qtdpaginas.getText()));
		vo.setQtdExemplares(Integer.parseInt(qtdexemplares.getText()));
		vo.setValorAluguel(Double.parseDouble(valoraluguel.getText()));
		
		bo.editarProduto(vo);
				
		//fecha a tela
		Stage stage = (Stage) painel.getScene().getWindow();
		
		//Abre a POP-UP confirmando a edição
		Telas.telaCadastroEfetuado();
		ConfirmarCadastro.confirmarCadastro.alteraTexto("Editado com sucesso!");
		PesquisarLivro.pesquisarLivro.atualizaTableView();
		
		stage.close();
	}
	
	public void insereTexto(LivrosVO livro)
	{
		id = livro.getId();
		titulo.setText(livro.getTitulo());
		genero.setText(livro.getGenero());
		ano.setText(""+livro.getAnoLancamento().getWeekYear());
		qtdpaginas.setText(Integer.toString(livro.getQtdPaginas()));
		qtdexemplares.setText(Integer.toString(livro.getQtdExemplares()));
		valoraluguel.setText(Double.toString(livro.getValorAluguel()));
	}
}
