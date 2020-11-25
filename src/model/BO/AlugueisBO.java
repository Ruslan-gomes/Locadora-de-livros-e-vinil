package model.BO;

import java.util.Calendar;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public class AlugueisBO implements AlugueisInterBO {
	
	public void cadastrarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO e vai cadastrar esse aluguel no BD.
	}
	
	public void cadastrarDevolucao(AlugueisVO aluguel) {
		/* Vai receber um objeto do tipo AlugueisVO e vai cadastrar a data de devolução desse 
		 * aluguel no BD.
		 */
	}
	
	public void deletarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO e vai deletar ele do BD.
	}
	
	public void editarAluguel(AlugueisVO aluguel) {
		// Vai receber um objeto do tipo AlugueisVO contendo as alterações desejadas e vai adiciona-las no BD. 
	}
	
	public void pesquisarAluguel(AlugueisVO aluguel) {
		/* Vai receber um objeto do tipo AlugueisVO com infromação do produto ou cliente, pesquisar no BD
		 * e retornar com todas as informações desse aluguél.
		 */
	}
	
	//Cliente específico
	public AlugueisVO [] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim) {
		/* Vai receber um cliente e a data de inicio e fim para pesquisar todos os aluguéis daquele cliente 
		 * neste intervalo de tempo e então retornar um array com todos os alugueis do cliente.
		 */
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	//Todos os clientes
	public AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim) {
		/* Vai receber uma data de inicio e fim, pesquisar todos os aluguéis dentro desse espaço de tempo
		 * e retornar um array com todos os aluguéis.
		 */
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
	
	public AlugueisVO [] relatorioFaturaMensal(Calendar mes) {
		// Vai receber um mês como parâmentro e vai retornar um array com todos os alugueis daquele mês
		
		AlugueisVO [] relatorio = new AlugueisVO[1];// Apenas para tirar o erro de retorno
		return relatorio;
	}
}
