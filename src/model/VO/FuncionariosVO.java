package model.VO;

import java.util.Calendar;

public class FuncionariosVO extends PessoasVO{
	private Long id;
	private String login;
	private String senha;
	private String cargo;
	private Calendar data_demissao;
	
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha == null) {
			System.out.println("Senha nula");
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

	public Calendar getData_demissao() {
		return data_demissao;
	}

	public void setData_demissao(Calendar data_demissao) {
		if(data_demissao == null) {
			System.out.println("[ERRO] Data demissão vazia");
		}else {
			this.data_demissao = data_demissao;
		}
	}
	
}