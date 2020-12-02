package model.VO;

public class FuncionariosVO extends PessoasVO{
	private Long id;
	private String login;
	private int senha;
	private String cargo;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
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