package model.VO;

public class LivrosVO extends ProdutosVO {
	private String genero;
	private String anoLancamento;
	private int qtdPaginas;


	//M�todos getters and setters.
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if(genero == null || genero.isEmpty())
		{
			System.out.println("G�nero inv�lido!");
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
			System.out.println("Ano de lan�amento inv�lido!");
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
			System.out.println("Quantidade de p�ginas inv�lida!");
		}
		else
		{
			this.qtdPaginas = qtdPaginas;
		}
	}


}
