package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.ProdutosBO;
import model.VO.DiscosVO;
import view.Telas;

public class EditarDisco {
	public static EditarDisco editarDisco;
	int id;
	
	@FXML private Pane painel;
	
	@FXML private TextField titulo;
	@FXML private TextField nomebanda;
	@FXML private TextField estilo;
	@FXML private TextField qtdexemplares;
	@FXML private TextField valoraluguel;
	
	ProdutosBO<DiscosVO> bo = new ProdutosBO<DiscosVO>();
	
	@FXML
	void initialize() {
		//cpfcliente.setText("123");
		editarDisco = this;
	}
	
	public void editarDisco(ActionEvent event) throws Exception
	{
		DiscosVO vo = new DiscosVO();
		vo.setId(id);
		vo.setTitulo(titulo.getText());
		vo.setNomeBanda(nomebanda.getText());
		vo.setEstilo(estilo.getText());
		vo.setQtdExemplares(Integer.parseInt(qtdexemplares.getText()));
		vo.setValorAluguel(Double.parseDouble(valoraluguel.getText()));
		
		bo.editarProduto(vo);
		//fecha a tela
		Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		PesquisarDisco.pesquisarDisco.atualizaTableView();
		stage.close();
	}
	
	public void insereTexto(DiscosVO disco)
	{
		id = disco.getId();
		titulo.setText(disco.getTitulo());
		nomebanda.setText(disco.getNomeBanda());
		estilo.setText(disco.getEstilo());
		qtdexemplares.setText(Integer.toString(disco.getQtdExemplares()));
		valoraluguel.setText(Double.toString(disco.getValorAluguel()));
	}
}
