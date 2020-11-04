package model.VO;

class ClientesVO {
	private String nome;
	private String cpf;
	private String endereco;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.isEmpty() || nome == null)
		{
			System.out.println("Nome inv�lido!");
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
		if(cpf.isEmpty() || cpf == null)
		{
			System.out.println("CPF inv�lido!");
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
		if(endereco.isEmpty() || endereco == null)
		{
			System.out.println("Endere�o inv�lido!");
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
