package controller;

import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BO.ProdutosBO;
import model.VO.LivrosVO;
import view.Telas;

public class CadastrarLivro {
	
	@FXML private TextField titulo;
	@FXML private TextField genero;
	@FXML private TextField qtdpaginas;
	@FXML private TextField anolancamento;
	@FXML private TextField qtdexemplares;
	@FXML private TextField valoraluguel;
	@FXML private Label mensagem;
	
	
	ProdutosBO<LivrosVO> bo = new ProdutosBO<LivrosVO>();
	
	public void cadastrarLivro(ActionEvent event) throws Exception
	{
		if(titulo.getText().isEmpty() || genero.getText().isEmpty() || qtdpaginas.getText().isEmpty() || anolancamento.getText().isEmpty() || qtdexemplares.getText().isEmpty() || valoraluguel.getText().isEmpty())
		{
			mensagem.setVisible(true);
		}
		else
		{
			LivrosVO vo = new LivrosVO();
			vo.setTitulo(titulo.getText());
			vo.setGenero(genero.getText());
			
			int paginas = Integer.parseInt(qtdpaginas.getText());
			vo.setQtdPaginas(paginas);
			
			int a = Integer.parseInt(anolancamento.getText());
			Calendar data = Calendar.getInstance();
			data.set(Calendar.YEAR, a);
			vo.setAnoLancamento(data);
			
			double valor = Double.parseDouble(valoraluguel.getText());
			vo.setValorAluguel(valor);
			
			try {
				bo.cadastrarProduto(vo);
				
				titulo.setText("");
				genero.setText("");
				qtdpaginas.setText("");
				qtdexemplares.setText("");
				anolancamento.setText("");
				valoraluguel.setText("");
				mensagem.setVisible(false);
				
				Telas.telaCadastroEfetuado();
			}catch(Exception e) {
				Telas.telaErro();
			}
		}
		
	}
}
