package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.BO.ProdutosBO;
import model.VO.DiscosVO;
import view.Telas;

public class CadastrarDisco {
	@FXML private TextField titulo;
	@FXML private TextField nomebanda;
	@FXML private TextField estilo;
	@FXML private TextField qtdexemplares;
	@FXML private TextField valoraluguel;
	
	ProdutosBO<DiscosVO> bo = new ProdutosBO<DiscosVO>();
	
	public void cadastrarDisco(ActionEvent event) throws Exception
	{
		DiscosVO vo = new DiscosVO();
		vo.setTitulo(titulo.getText());
		vo.setEstilo(estilo.getText());
		vo.setNomeBanda(nomebanda.getText());
		
		int quantidade = Integer.parseInt(qtdexemplares.getText());
		vo.setQtdExemplares(quantidade);
		
		double valor = Double.parseDouble(valoraluguel.getText());
		vo.setValorAluguel(valor);
		
		
		try {
			bo.cadastrarProduto(vo);
			
			titulo.setText("");
			nomebanda.setText("");
			estilo.setText("");
			qtdexemplares.setText("");
			valoraluguel.setText("");
			
			Telas.telaCadastroEfetuado();
		}catch(Exception e) {
			Telas.telaErro();
		}
	}
}
