package model.VO;

class Discos {
	private String titulo;
	private String nomeBanda;
	private String estilo;
	private int qtdExemplares;
	private double valorAluguel;

	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.isEmpty())
		{
			System.out.println("T�tulo inv�lido!");
		}
		else
		{
			this.titulo = titulo;
		}
	}

	public String getNomeBanda() {
		return nomeBanda;
	}

	public void setNomeBanda(String nomeBanda) {
		if(nomeBanda.isEmpty())
		{
			System.out.println("Nome de banda inv�lido!");
		}
		else
		{
			this.nomeBanda = nomeBanda;
		}
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		if(estilo.isEmpty())
		{
			System.out.println("Estilo inv�lido!");
		}
		else
		{
			this.estilo = estilo;
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
		if(valorAluguel < 0)
		{
			System.out.println("Valor de aluguel inv�lido!");
		}
		else
		{
			this.valorAluguel = valorAluguel;
		}
	}

	void cadastrarDisco(){

	}

	void deletarDisco(){

	}

	void editarDisco(){

	}

	void pesquisarDisco(){

	}
}
