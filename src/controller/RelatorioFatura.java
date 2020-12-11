package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;

public class RelatorioFatura {
	
	AlugueisBO bo = new AlugueisBO();
	
	@FXML private DatePicker data;
	@FXML private TextField quantidadealugueis;
	@FXML private TextField rentabilidade;
	
	
	public void calcularFatura(ActionEvent event) throws Exception
	{
		
		Calendar data2 = Calendar.getInstance();
		data2.setTime(Date.valueOf(data.getValue()));
		
		AlugueisVO vo = new AlugueisVO();
		vo = bo.relatorioFaturaMensal(data2);
		
		quantidadealugueis.setText(Integer.toString(vo.getQtdAlugados()));
		quantidadealugueis.setVisible(true);
		
		rentabilidade.setText(Double.toString(vo.getValorTotal()));
		rentabilidade.setVisible(true);
	}
}
