package model.VO;

import java.util.Calendar;

public abstract class ProdutosVO {
	private int id;
	private String titulo;
	private int qtdExemplares;
	private double valorAluguel;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id <= 0) {
			System.out.println("ID inv�lido!");
		}else {
			this.id = id;
		}
	}
	
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
		if(valorAluguel <= 0 && valorAluguel >=200)
		{
			System.out.println("Valor de aluguel inv�lido!");
		}
		else
		{
			this.valorAluguel = valorAluguel;
		}
	}
	
	
	
	//m�todos abstratos da classe DiscosVO.
	
	public abstract String getNomeBanda(); 

	public abstract void setNomeBanda(String nomeBanda);

	public abstract String getEstilo();

	public abstract void setEstilo(String estilo);

	
	//m�todos abstratos da classe LivrosVO
	
	public abstract String getGenero();

	public abstract void setGenero(String genero);

	public abstract Calendar getAnoLancamento();

	public abstract void setAnoLancamento(Calendar anoLancamento);

	public abstract void setQtdPaginas(int qtdPaginas);


}
