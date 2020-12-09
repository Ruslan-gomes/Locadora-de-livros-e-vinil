package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.BO.AlugueisBO;

public class EditarAlugueis {

	@FXML private TextField cpfcliente;
	@FXML private TextField nomeproduto;
	@FXML private TextField novonomeproduto;
	@FXML private TextField quantidadealugada;
	@FXML private DatePicker dataemprestimo;
	@FXML private TextField valoraluguel;
	
	
	AlugueisBO bo = new AlugueisBO();
	
	public void editarAluguel(ActionEvent event) throws Exception
	{
		
	}
}
