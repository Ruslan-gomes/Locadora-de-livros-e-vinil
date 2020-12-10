package model.VO;

import java.util.Calendar;

public class AlugueisVO{
	private ClientesVO cliente;
	private String nomeProdutoAntigo;
	private String nomeProduto;
	private LivrosVO livro;
	private DiscosVO disco;
	private int qtdExemplares;
	private int qtdAlugados;
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private double valorTotal;
	
	public ClientesVO getCliente() {
		return cliente;
	}

	public void setCliente(ClientesVO cliente) {
		if(cliente == null) {
			System.out.println("[ERRO] Cliente vazio");
		}else {
			this.cliente = cliente;
		}
	}

	public String getNomeProdutoAntigo() {
		return nomeProdutoAntigo;
	}

	public void setNomeProdutoAntigo(String nomeProdutoAntigo) {
		this.nomeProdutoAntigo = nomeProdutoAntigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		if(nomeProduto == null || nomeProduto.isEmpty()) {
			System.out.println("Nome do produto inválido!");
		}else {
			this.nomeProduto = nomeProduto;
		}
	}

	public LivrosVO getLivro() {
		return livro;
	}

	public void setLivro(LivrosVO livro) {
		if(livro == null) {
			System.out.println("[ERRO] Livro vazio");
		}else {
			this.livro = livro;
		}
	}

	public DiscosVO getDisco() {
		return disco;
	}

	public void setDisco(DiscosVO disco) {
		if(disco == null) {
			System.out.println("[ERRO] Disco vazio");
		}else {
			this.disco = disco;
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
	
	public int getQtdAlugados() {
		return qtdAlugados;
	}

	public void setQtdAlugados(int qtdAlugados) {
		if(qtdAlugados < 0) {
			System.out.println("[ERRO] Quantidade de alugados inválida");
		}else {
			this.qtdAlugados = qtdAlugados;
		}
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		if(dataEmprestimo == null) {
			System.out.println("[ERRO] Data de empréstimo nula");
		}else {
			this.dataEmprestimo = dataEmprestimo;
		}
	}
	
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		if(dataDevolucao == null) {
			System.out.println("[ERRO] Data de devolução nula");
		}else {
			this.dataDevolucao = dataDevolucao;
		}
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		if(valorTotal < 0) {
			System.out.println("[ERRO] Valor total inválido ou negativo");
		}else {
			this.valorTotal = valorTotal;
		}
		
	}

}