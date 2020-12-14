package controller;

import java.sql.Date;
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

public class CadastrarDevolucao {
	
	@FXML private TextField cpfcliente;
	@FXML private TextField nomeproduto;
	@FXML private DatePicker datadevolucao;
	@FXML private Label mensagem;
	@FXML private Pane painelConteudo;
	
	AlugueisBO bo = new AlugueisBO();
	
	public void telaCadastrarDevolucao(ActionEvent event) throws Exception {
		Telas.telaCadastraDevolucao(painelConteudo);
	}
	
	public void cadastrarDevolucao(ActionEvent event) throws Exception
	{
		if(cpfcliente.getText().isEmpty() || nomeproduto.getText().isEmpty() || datadevolucao.getValue() == null)
		{
			mensagem.setVisible(true);
		}
		else
		{
			AlugueisVO vo = new AlugueisVO();
			ClientesVO cliente = new ClientesVO();
			vo.setCliente(cliente);
			vo.getCliente().setCpf(cpfcliente.getText());
			vo.setNomeProduto(nomeproduto.getText());
			
			Calendar date = Calendar.getInstance();
			date.setTime(Date.valueOf(datadevolucao.getValue()));
			vo.setDataDevolucao(date);
			
			try {
				bo.cadastrarDevolucao(vo);
				
				cpfcliente.setText("");
				nomeproduto.setText("");
				datadevolucao.setValue(null);
				mensagem.setVisible(false);
				
				Telas.telaCadastroEfetuado();
				
			}catch(Exception e) {
				Telas.telaErro();
			}
		}
	}
}
