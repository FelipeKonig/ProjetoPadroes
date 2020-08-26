package Produto;

public class ProdutoNaoDuravel extends Produto {

	private String data_validade;

	public ProdutoNaoDuravel(String nome, String categoria, String data_criacao, String descricao, int quantidade,
			float valor, String data_validade) {
		super(nome, categoria, data_criacao, descricao, quantidade, valor);
		this.data_validade = data_validade;
	}

	public String getData_validade() {
		return data_validade;
	}

}
