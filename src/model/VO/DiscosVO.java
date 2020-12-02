package model.VO;

import java.util.Calendar;

public class DiscosVO extends ProdutosVO{
	private String nomeBanda;
	private String estilo;

	
	public String getNomeBanda() {
		return nomeBanda;
	}

	public void setNomeBanda(String nomeBanda) {
		if(nomeBanda == null || nomeBanda.isEmpty())
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
		if(estilo == null || estilo.isEmpty())
		{
			System.out.println("Estilo inv�lido!");
		}
		else
		{
			this.estilo = estilo;
		}
	}

	
	
	// m�todos vazios provenientes dos m�todos abstratos da classe LivrosVO.
	@Override
	public String getGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGenero(String genero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calendar getAnoLancamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAnoLancamento(Calendar anoLancamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setQtdPaginas(int qtdPaginas) {
		// TODO Auto-generated method stub
		
	}

}
