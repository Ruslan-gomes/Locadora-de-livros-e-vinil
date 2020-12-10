package model.VO;

public abstract class PessoasVO {
	protected String cpf;
	protected String cpfAntigo;
	protected String nome;
	protected String endereco;
	
	
	//getters e setters.
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.isEmpty() )
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
		if(cpf == null || cpf.isEmpty() || cpf.length() < 11)
		{
			System.out.println("CPF inválido!");
		}
		else
		{
			this.cpf = cpf;
		}
	}
	
	public String getCpfAntigo() {
		return cpfAntigo;
	}

	public void setCpfAntigo(String cpf) {
		if(cpf == null || cpf.isEmpty() || cpf.length() < 11)
		{
			System.out.println("CPF inválido!");
		}
		else
		{
			this.cpfAntigo = cpf;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if(endereco == null || endereco.isEmpty())
		{
			System.out.println("Endereço inválido!");
		}
		else
		{
			this.endereco = endereco;
		}	
	}
	
	
	//métodos abstratos da classe funcionariosVO.
	
	public abstract String getLogin();

	public abstract void setLogin(String login);

	public abstract String getSenha();

	public abstract void setSenha(String senha);

	public abstract String getCargo();

	public abstract void setCargo(String cargo);
}
