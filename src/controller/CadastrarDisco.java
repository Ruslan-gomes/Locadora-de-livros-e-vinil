package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
	@FXML private Label mensagem;
	
	ProdutosBO<DiscosVO> bo = new ProdutosBO<DiscosVO>();
	
	public void cadastrarDisco(ActionEvent event) throws Exception
	{
		if(titulo.getText().isEmpty() || nomebanda.getText().isEmpty() || estilo.getText().isEmpty() || qtdexemplares.getText().isEmpty() || valoraluguel.getText().isEmpty())
		{
			mensagem.setVisible(true);
		}
		else
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
				mensagem.setVisible(false);
				
				Telas.telaCadastroEfetuado();
			}catch(Exception e) {
				Telas.telaErro();
			}
		}
	}
}
