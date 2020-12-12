package controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	
	
	ProdutosBO<LivrosVO> bo = new ProdutosBO<LivrosVO>();
	
	public void cadastrarLivro(ActionEvent event) throws Exception
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
			
			Telas.telaCadastroEfetuado();
		}catch(Exception e) {
			Telas.telaErro();
		}
	}
}
