package model.VO;

public class ProdutosVO {
	private String titulo;
	private int qtdExemplares;
	private double valorAluguel;
	
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo == null || titulo.isEmpty())
		{
			System.out.println("T�tulo inv�lido!");
		}
		else
		{
			this.titulo = titulo;
		}
		
	}
	
	public int getQtdExemplares() {
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares) {
		if(qtdExemplares <= 0)
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
		if(valorAluguel <= 0 && valorAluguel >=200)
		{
			System.out.println("Valor de aluguel inv�lido!");
		}
		else
		{
			this.valorAluguel = valorAluguel;
		}
	}

}
