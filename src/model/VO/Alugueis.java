package model.VO;

import java.util.Calendar;

class Alugueis{
	private String cpfCliente;
	private String nomeProduto;
	private int qtdExemplares;
	private Calendar dataEmprestimo;
	
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		if(cpfCliente == null || cpfCliente.trim().equals("")) {
			System.out.println("[ERRO] CPF vazio");
		}else {
			this.cpfCliente = cpfCliente;
		}
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		if(nomeProduto == null || nomeProduto.trim().equals("")) {
			System.out.println("[ERRO] Nome vazio");
		}else {
			this.nomeProduto = nomeProduto;
		}
	}

	public int getQtdExemplares() {
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares) {
		if(qtdExemplares < 1) {
			System.out.println("[ERRO] Quantidade inválida");
		}else {
			this.qtdExemplares = qtdExemplares;
		}
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		if(dataEmprestimo == null) {
			System.out.println("[ERRO] Data nula");
		}else {
			this.dataEmprestimo = dataEmprestimo;
		}
	}
	

	void cadastrarAluguel() {
		
	}
	
	void deletarAluguel() {
		
	}
	
	void editarAluguel() {
		
	}
	
	void pesquisarAluguel() {
		
	}
}