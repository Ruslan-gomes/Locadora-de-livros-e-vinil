package model.BO;

//import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import model.VO.AlugueisVO;
import model.VO.ClientesVO;

public interface AlugueisInterBO {
	public void cadastrarAluguel(AlugueisVO aluguel);
	public void cadastrarDevolucao(AlugueisVO aluguel);
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguel(AlugueisVO aluguel);
	public List<AlugueisVO> pesquisarAluguel(AlugueisVO aluguel);
	public List<AlugueisVO> pesquisarAluguel(Calendar dataInicio, Calendar dataFim);
	public List<AlugueisVO> pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim);
	public List<AlugueisVO> listar();
	public AlugueisVO [] relatorioAlugados(ClientesVO cliente, Calendar dataInicio, Calendar dataFim);
	public AlugueisVO [] relatorioAlugados(Calendar dataInicio, Calendar dataFim);
	public AlugueisVO relatorioFaturaMensal(Calendar mes);
}
