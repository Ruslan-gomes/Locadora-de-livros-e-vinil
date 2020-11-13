package model.VO;

public class FuncionariosVO extends PessoasVO{
	private String login;
	private String senha;
	private String cargo;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(login == null || login.isEmpty()) {
			System.out.println("[ERRO] Login vazio");
		}else {
			this.login = login;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha == null || senha.isEmpty()) {
			System.out.println("[ERRO] Senha vazio");
		}else {
			this.senha = senha;
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if(cargo == null || cargo.isEmpty()) {
			System.out.println("[ERRO] Cargo vazio");
		}else {
			this.cargo = cargo;
		}
	}
	
}