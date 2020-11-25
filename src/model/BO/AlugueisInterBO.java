package model.BO;

import java.util.Calendar;

import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public interface AlugueisInterBO {
	public void cadastrarAluguel(AlugueisVO aluguel);
	public void cadastrarDevolucao(AlugueisVO aluguel);
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguel(AlugueisVO aluguel);
	public void pesquisarAluguel(AlugueisVO aluguel);
	public AlugueisVO [] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim);
	public AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim);
	public AlugueisVO [] relatorioFaturaMensal(Calendar mes);
}