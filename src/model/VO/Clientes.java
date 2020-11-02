package model.VO;

class Clientes {
	private String nome;
	private String cpf;
	private String endereco;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.isEmpty())
		{
			System.out.println("Nome inválido!");
		}
		else
		{
		this.nome = nome;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.isEmpty())
		{
			System.out.println("CPF inválido!");
		}
		else
		{
			this.cpf = cpf;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if(endereco.isEmpty())
		{
			System.out.println("Endereço inválido!");
		}
		else
		{
			this.endereco = endereco;
		}
	}
	
	void castrarCliente(){

	}

	void deletarCliente(){

	}

	void editarCliente(){

	}

	void pesquisarCliente(){

	}
}
