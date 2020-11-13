package model.VO;

public class LivrosVO extends ProdutosVO {
	private String genero;
	private String anoLancamento;
	private int qtdPaginas;


	//Métodos getters and setters.
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if(genero == null || genero.isEmpty())
		{
			System.out.println("Gênero inválido!");
		}
		else 
		{
			this.genero = genero;
		}
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		if(anoLancamento == null || anoLancamento.isEmpty() )
		{
			System.out.println("Ano de lançamento inválido!");
		}
		else
		{
			this.anoLancamento = anoLancamento;
		}
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		if(qtdPaginas < 0)
		{
			System.out.println("Quantidade de páginas inválida!");
		}
		else
		{
			this.qtdPaginas = qtdPaginas;
		}
	}


}
