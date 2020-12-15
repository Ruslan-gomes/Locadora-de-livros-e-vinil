package model.BO;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import exception.ErroCadastroAluguel;
import model.VO.AlugueisVO;

public interface AlugueisInterBO {
	public void cadastrarAluguel(AlugueisVO aluguel) throws ErroCadastroAluguel, IOException;
	public void cadastrarDevolucao(AlugueisVO aluguel) throws ErroCadastroAluguel, IOException;
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguel(AlugueisVO aluguel);
	public List<AlugueisVO> pesquisarAluguel(AlugueisVO aluguel);
	public List<AlugueisVO> pesquisarAluguel(Calendar dataInicio, Calendar dataFim);
	public List<AlugueisVO> pesquisarAluguelCliente(AlugueisVO aluguel, Calendar dataInicio, Calendar dataFim);
	public List<AlugueisVO> listar();
	public AlugueisVO relatorioFaturaMensal(Calendar mes);
	public List<AlugueisVO> pesquisarAluguelDevolvido(AlugueisVO aluguel);
}
