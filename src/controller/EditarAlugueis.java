package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.BO.AlugueisBO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;
import view.Telas;

public class EditarAlugueis {
	public static EditarAlugueis editarAluguel;
	@FXML private Pane painel;
	@FXML protected TextField cpfcliente;
	@FXML private TextField nomeproduto;
	@FXML private TextField novonomeproduto;
	@FXML private TextField quantidadealugada;
	@FXML private DatePicker dataemprestimo;
	@FXML private DatePicker datadevolucao;
	@FXML private TextField valoraluguel;
	
	String cpfAntigo;
	String nomeProdutoAntigo;
	AlugueisBO bo = new AlugueisBO();
	
	@FXML
	void initialize() {
		//cpfcliente.setText("123");
		editarAluguel = this;
	}
	
	public void editarAluguel(ActionEvent event) throws Exception{
		//Monta o objeto aluguelEditado
		ClientesVO cliente = new ClientesVO();
		cliente.setCpfAntigo(cpfAntigo);
		cliente.setCpf(cpfcliente.getText());
		
		AlugueisVO aluguelEditado = new AlugueisVO();
		aluguelEditado.setCliente(cliente);
		aluguelEditado.setNomeProdutoAntigo(nomeProdutoAntigo);
		aluguelEditado.setNomeProduto(nomeproduto.getText());
		aluguelEditado.setQtdAlugados(Integer.parseInt(quantidadealugada.getText()));
		
		Calendar cal = Calendar.getInstance();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(dataemprestimo.getValue().atStartOfDay(defaultZoneId).toInstant());
		cal.setTime(date);
		aluguelEditado.setDataEmprestimo(cal);
		
		Calendar cal2 = Calendar.getInstance();
		ZoneId defaultZoneId2 = ZoneId.systemDefault();
		Date date2 = Date.from(datadevolucao.getValue().atStartOfDay(defaultZoneId2).toInstant());
		cal2.setTime(date2);
		aluguelEditado.setDataDevolucao(cal2);
		
		aluguelEditado.setValorTotal(Double.parseDouble(valoraluguel.getText()));
		
		AlugueisBO bo = new AlugueisBO();
		bo.editarAluguel(aluguelEditado);
		
		
		//fecha a tela
		Stage stage = (Stage) painel.getScene().getWindow();
		Telas.getPrimaryStage().setOpacity(1);
		PesquisarAlugueis.pesquisarAlugueis.atualizaTableView();
		stage.close();
		
	}
	
	public void insereTexto(AlugueisVO aluguel) {
		//Armazena nas variáveis os dados necessários para editar o aluguel
		cpfAntigo = aluguel.getCliente().getCpf();
		nomeProdutoAntigo = aluguel.getNomeProduto();
		
		//Joga os dados na tela
		cpfcliente.setText(aluguel.getCliente().getCpf());
		nomeproduto.setText(aluguel.getNomeProduto());
		quantidadealugada.setText(""+ aluguel.getQtdAlugados());
		
		TimeZone tz = aluguel.getDataEmprestimo().getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		LocalDate localDate = LocalDateTime.ofInstant(aluguel.getDataEmprestimo().toInstant(), zid).toLocalDate();
		dataemprestimo.setValue(localDate);
		
		TimeZone tz2 = aluguel.getDataDevolucao().getTimeZone();
		ZoneId zid2 = tz2 == null ? ZoneId.systemDefault() : tz2.toZoneId();
		LocalDate localDate2 = LocalDateTime.ofInstant(aluguel.getDataDevolucao().toInstant(), zid2).toLocalDate();
		datadevolucao.setValue(localDate2);
		valoraluguel.setText(""+ aluguel.getValorTotal());
	}
	
}
