package model.DAO;

import java.util.Calendar;
import java.util.List;

import model.VO.AlugueisVO;

public interface AlugueisInterDAO {
	public void cadastrarAluguel(AlugueisVO aluguel);
	public void cadastrarDevolucao(AlugueisVO aluguel);
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguel(AlugueisVO aluguel);
	public List<AlugueisVO> pesquisarAluguel(Calendar dataInicio, Calendar dataFim);
	public List<AlugueisVO> pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim);
	public List<AlugueisVO> listar();
	public double faturaMensal(Calendar mes);
}
