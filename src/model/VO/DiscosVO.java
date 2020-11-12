package model.VO;

public class DiscosVO extends ProdutoVO{
	private String nomeBanda;
	private String estilo;

	

	//Metodos getters e setters.
	public String getNomeBanda() {
		return nomeBanda;
	}

	public void setNomeBanda(String nomeBanda) {
		if(nomeBanda == null || nomeBanda.isEmpty())
		{
			System.out.println("Nome de banda inválido!");
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
			System.out.println("Estilo inválido!");
		}
		else
		{
			this.estilo = estilo;
		}
	}

	
	//metodos gerais.
	
	public void cadastrarDisco(){

	}

	public void deletarDisco(){

	}

	public void editarDisco(){

	}

	public void pesquisarDisco(){

	}
}
