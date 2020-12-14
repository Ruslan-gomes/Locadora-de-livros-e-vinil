package controller;

import java.sql.Date;
//import java.time.LocalDate;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;
import view.Telas;

public class CadastrarAluguel {
	@FXML private TextField cpfcliente;
	@FXML private TextField nomeproduto;
	@FXML private TextField quantidadealugada;
	@FXML private DatePicker dataemprestimo;
	@FXML private TextField valortotal;
	@FXML private Label errocadastro;
	@FXML private Label mensagem;
	@FXML private Pane painelConteudo;
	
	AlugueisBO bo = new AlugueisBO();
	
	public void telaCadastrarAluguel(ActionEvent event) throws Exception {
		Telas.telaCadastraAluguel(painelConteudo);
	}
	
	
	public void cadastrarAluguel(ActionEvent event) throws Exception
	{
		if(cpfcliente.getText().isEmpty() || nomeproduto.getText().isEmpty() || quantidadealugada.getText().isEmpty() || dataemprestimo.getValue() == null || valortotal.getText().isEmpty())
		{
			errocadastro.setVisible(true);
		}
		else
		{
			AlugueisVO vo = new AlugueisVO();
			ClientesVO cliente = new ClientesVO();
			vo.setCliente(cliente);
			vo.getCliente().setCpf(cpfcliente.getText());
			vo.setNomeProduto(nomeproduto.getText());
			int quantidaealugados = Integer.parseInt(quantidadealugada.getText());
			vo.setQtdAlugados(quantidaealugados);
			
			Calendar data = Calendar.getInstance();
			data.setTime(Date.valueOf(dataemprestimo.getValue()));
			vo.setDataEmprestimo(data);
			
			double valor = Double.parseDouble(valortotal.getText());
			vo.setValorTotal(valor);
			
			
			
			try {
				bo.cadastrarAluguel(vo);
				
				Telas.telaCadastroEfetuado();
				
				cpfcliente.setText("");
				nomeproduto.setText("");
				quantidadealugada.setText("");
				dataemprestimo.setValue(null);
				valortotal.setText("");
				errocadastro.setVisible(false);
				
			}catch(Exception e) {
				Telas.telaErro();
			}
		}
	}
}
