package model.DAO;

import java.sql.ResultSet;
import java.util.Calendar;

import model.VO.AlugueisVO;

public interface AlugueisInterDAO {
	public void cadastrarAluguel(AlugueisVO aluguel);
	public void cadastrarDevolucao(AlugueisVO aluguel);
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguel(AlugueisVO aluguel);
	public ResultSet pesquisarAluguel(Calendar dataInicio, Calendar dataFim);
	public ResultSet pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim);
	public ResultSet listar();
	public double faturaMensal(Calendar mes);
}
