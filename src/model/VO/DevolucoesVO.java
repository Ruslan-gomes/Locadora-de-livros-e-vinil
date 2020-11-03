package model.VO;

import java.util.Calendar;

class Devolucoes{
	private String cpfCliente;
	private String nomeProduto;
	private int qtdExemplares;
	private Calendar dataDevolucao;
	
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		if(cpfCliente == null || cpfCliente.isEmpty()) {
			System.out.println("[ERRO] CPF vazio");
		}else {
			this.cpfCliente = cpfCliente;
		}
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		if(nomeProduto == null || nomeProduto.isEmpty()) {
			System.out.println("[ERRO] Nome do produto vazio");
		}else {
			this.nomeProduto = nomeProduto;
		}
	}

	public int getQtdExemplares() {
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares) {
		if(qtdExemplares == null || qtdExemplares < 1) {
			System.out.println("[ERRO] Quantidade inválida");
		}else {
			this.qtdExemplares = qtdExemplares;
		}
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		if(dataDevolucao == null) {
			System.out.println("[ERRO] Data nula");
		}else {
			this.dataDevolucao = dataDevolucao;
		}
	}

	
	void cadastrarDevolucao(){
		
	}
	
	void deletarDevolucao(){
	
	}
	
	void editarDevolucao(){
		
	}	
	
	void pesquisarDevolucao(){
		
	}
}