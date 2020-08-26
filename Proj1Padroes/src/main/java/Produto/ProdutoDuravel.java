package Produto;

public class ProdutoDuravel extends Produto {

	private String tempo_garantia;

	public ProdutoDuravel(String nome, String categoria, String data_criacao, String descricao, int quantidade,
			float valor, String tempo_garantia) {
		super(nome, categoria, data_criacao, descricao, quantidade, valor);
		this.tempo_garantia = tempo_garantia;
	}

	public String getTempo_garantia() {
		return tempo_garantia;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;

	}

}
