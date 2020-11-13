package model.BO;

import java.util.Calendar;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public class AlugueisBO {
	
	void cadastrarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO e vai cadastrar esse aluguel no BD.
	}
	
	void cadastrarDevolucao(AlugueisVO aluguel) {
		/* Vai receber um objeto do tipo AlugueisVO e vai cadastrar a data de devolu��o desse 
		 * aluguel no BD.
		 */
	}
	
	void deletarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO e vai deletar ele do BD.
	}
	
	void editarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO contendo as altera��es desejadas e vai adiciona-las no BD. 
	}
	
	void pesquisarAluguel(AlugueisVO aluguel) {
		/* Vai receber um objeto do tipo AlugueisVO com infroma��o do produto ou cliente, pesquisar no BD
		 * e retornar com todas as informa��es desse alugu�l.
		 */
	}
	
	//Cliente espec�fico
	AlugueisVO [] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim) {
		/* Vai receber um cliente e a data de inicio e fim para pesquisar todos os alugu�is daquele cliente 
		 * neste intervalo de tempo e ent�o retornar um array com todos os alugueis do cliente.
		 */
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	//Todos os clientes
	AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim) {
		/* Vai receber uma data de inicio e fim, pesquisar todos os alugu�is dentro desse espa�o de tempo
		 * e retornar um array com todos os alugu�is.
		 */
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	double relatorioFaturaMensal(Calendar mes) {
		double valorMensal = 0;// Apenas para tirar o erro de retorno
		
		return valorMensal;
	}
}
