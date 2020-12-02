package model.DAO;

import model.VO.AlugueisVO;

public interface AlugueisInterDAO {
	public void cadastrarAluguelLivro(AlugueisVO aluguel);
	public void cadastrarAluguelDisco(AlugueisVO aluguel);
	public void cadastrarDevolucaoLivro(AlugueisVO aluguel);
	public void cadastrarDevolucaoDisco(AlugueisVO aluguel);
	public void deletarAluguel(AlugueisVO aluguel);
	public void editarAluguelLivro(AlugueisVO aluguel);
	public void editarAluguelDisco(AlugueisVO aluguel);
	public AlugueisVO pesquisarAluguelLivro(AlugueisVO aluguel);
	public AlugueisVO pesquisarAluguelDisco(AlugueisVO aluguel);
}
