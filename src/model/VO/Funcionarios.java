package model.VO;

class Funcionarios{
	private String nome;
	private String login;
	private String senha;
	private String cargo;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.trim().equals("")) {
			System.out.println("[ERRO] Nome vazio");
		}else {
			this.nome = nome;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(login == null || login.trim().equals("")) {
			System.out.println("[ERRO] Login vazio");
		}else {
			this.login = login;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha == null || senha.trim().equals("")) {
			System.out.println("[ERRO] Senha vazio");
		}else {
			this.senha = senha;
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if(cargo == null || cargo.trim().equals("")) {
			System.out.println("[ERRO] Cargo vazio");
		}else {
			this.cargo = cargo;
		}
	}
	

	void cadastrarFuncionario() {
		
	}
	
	void deletarFuncionario() {
		
	}
	
	void editarFuncionario() {
		
	}
	
	void pesquisarFuncionario() {
		
	}
}