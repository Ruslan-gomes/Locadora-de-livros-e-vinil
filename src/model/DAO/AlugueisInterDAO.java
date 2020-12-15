package model.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Calendar;

import exception.ErroCadastroAluguel;
import model.VO.AlugueisVO;

public interface AlugueisInterDAO {
	public void cadastrarAluguel(AlugueisVO aluguel);
	public void cadastrarDevolucao(AlugueisVO aluguel) throws ErroCadastroAluguel, IOException;
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguel(AlugueisVO aluguel);
	public ResultSet PesquisarAluguel(AlugueisVO aluguel);
	public ResultSet pesquisarAluguel(Calendar dataInicio, Calendar dataFim);
	public ResultSet pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim);
	public ResultSet listar();
	public ResultSet faturaMensal(Calendar mes);
}
