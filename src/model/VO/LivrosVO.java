package model.VO;

public class LivrosVO extends ProdutosVO {
	private String genero;
	private String anoLancamento;
	private int qtdPaginas;
	
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

	
	
	//m�todos vazios provenientes dos m�todos abstratos da classe DiscosVO.
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
