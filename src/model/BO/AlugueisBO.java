package model.BO;

import java.util.Calendar;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public class AlugueisBO {
	
	void cadastrarAluguel(AlugueisVO aluguel) {
		
	}
	
	void cadastrarDevolucao(AlugueisVO aluguel) {
		
	}
	
	void deletarAluguel(AlugueisVO aluguel) {
		
	}
	
	void editarAluguel(AlugueisVO aluguel) {
		
	}
	
	void pesquisarAluguel(AlugueisVO aluguel) {
		
	}
	
	//Cliente específico
	AlugueisVO [] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim) {
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	//Todos os clientes
	AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim) {
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	double relatorioFaturaMensal(Calendar mes) {
		double valorMensal = 0;// Apenas para tirar o erro de retorno
		
		return valorMensal;
	}
}
