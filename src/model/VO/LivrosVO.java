package model.VO;

class LivrosVO {
	private String titulo;
	private String genero;
	private String anoLancamento;
	private int qtdPaginas;
	private int qtdExemplares;
	private double valorAluguel;



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.isEmpty() || titulo == null)
		{
			System.out.println("T�tulo inv�lido!");
		}
		else
		{
			this.titulo = titulo;
		}	
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if(genero.isEmpty() || genero == null)
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
		if(anoLancamento.isEmpty() || anoLancamento == null)
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

	public int getQtdExemplares() {
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares) {
		if(qtdExemplares < 0)
		{
			System.out.println("Quantidade de exemplares inv�lida!");
		}
		else
		{
			this.qtdExemplares = qtdExemplares;
		}
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		if(valorAluguel < 0 && valorAluguel >=200 )
		{
			System.out.println("Valor de aluguel inv�lido!");
		}
		else
		{
			this.valorAluguel = valorAluguel;
		}
	}

	void cadastrarLivro(){

	}
	
	void deletarLivro(){

	}

	void editarLivro(){
		
	}

	void pesquisarLivro(){

	}
}
