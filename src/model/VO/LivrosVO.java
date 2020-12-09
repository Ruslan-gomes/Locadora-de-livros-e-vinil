package model.VO;

import java.util.Calendar;

public class LivrosVO extends ProdutosVO {
	private String genero;
	private Calendar anoLancamento;
	private int qtdPaginas;
	
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

	public Calendar getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Calendar anoLancamento) {
		if(anoLancamento != null)
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

	
	
	//métodos vazios provenientes dos métodos abstratos da classe DiscosVO.
	@Override
	public String getNomeBanda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNomeBanda(String nomeBanda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEstilo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstilo(String estilo) {
		// TODO Auto-generated method stub
		
	}


}
