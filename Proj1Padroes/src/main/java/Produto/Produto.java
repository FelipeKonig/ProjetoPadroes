package Produto;

public abstract class Produto {

	protected String nome, categoria, data_criacao, descricao;
	protected float valor;
	protected int quantidade = 0;

	public Produto(String nome, String categoria, String data_criacao, String descricao, int quantidade, float valor) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.data_criacao = data_criacao;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getData_criacao() {
		return data_criacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
