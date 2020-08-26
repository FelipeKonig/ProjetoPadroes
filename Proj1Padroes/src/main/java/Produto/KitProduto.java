package Produto;

import java.util.ArrayList;

public class KitProduto extends Produto {

	private ArrayList<ProdutoDuravel> pacote_produtos_duraveis = new ArrayList<ProdutoDuravel>();
	private ArrayList<ProdutoNaoDuravel> pacote_produtos_nao_duraveis = new ArrayList<ProdutoNaoDuravel>();

	public KitProduto(String nome, String categoria, String data_criacao, String descricao, int quantidade,float valor) {
		super(nome, categoria, data_criacao, descricao, quantidade, valor);
	}

	public ArrayList<ProdutoDuravel> getPacote_produtos_duraveis() {
		return pacote_produtos_duraveis;
	}

	public ArrayList<ProdutoNaoDuravel> getPacote_produtos_nao_duraveis() {
		return pacote_produtos_nao_duraveis;
	}

	@Override
	public String getNome() {

		if (pacote_produtos_duraveis.size() > 0) {

			System.out.println("Produtos duraveis do kit:");
			for (Produto produto : pacote_produtos_duraveis) {
				System.out.println(produto.getNome());
			}
		}

		if (pacote_produtos_nao_duraveis.size() > 0) {
			System.out.println("Produtos nao duraveis do kit:");
			for (Produto produto : pacote_produtos_nao_duraveis) {
				System.out.println(produto.getNome());
			}
		}

		System.out.println("Nome do kit: " + super.getNome());
		return super.getNome();
	}

	@Override
	public String getDescricao() {

		if (pacote_produtos_nao_duraveis.size() > 0) {
			System.out.println("Produtos duraveis do kit:");
			for (Produto produto : pacote_produtos_duraveis) {
				System.out.print(produto.getNome() + ": ");
				System.out.println(produto.getDescricao());
			}
		}
		if (pacote_produtos_nao_duraveis.size() > 0) {
			System.out.println("Produtos nao duraveis do kit:");
			for (Produto produto : pacote_produtos_nao_duraveis) {
				System.out.print(produto.getNome() + ": ");
				System.out.println(produto.getDescricao());
			}
		}
		System.out.println("Descrição do kit: " + super.getDescricao());
		return super.getDescricao();
	}

	@Override
	public int getQuantidade() {

		System.out.println("Produtos duraveis do kit:");
		for (Produto produto : pacote_produtos_duraveis) {
			System.out.print(produto.getNome() + ": ");
			System.out.println(produto.getQuantidade());
		}

		System.out.println("Produtos nao duraveis do kit:");
		for (Produto produto : pacote_produtos_nao_duraveis) {
			System.out.print(produto.getNome() + ": ");
			System.out.println(produto.getQuantidade());
		}
		System.out.println("Quantidade de kits: " + super.getQuantidade());
		return super.getQuantidade();
	}
	
	@Override
	public String toString() {
		System.out.println("Nome do kit: " + super.getNome());
		System.out.println("Categoria do kit: " + super.getCategoria());
		System.out.println("Descrição do kit: " + super.getDescricao());
		System.out.println("Quantidade de kits: " + super.getQuantidade());
		System.out.println("Valor do kit: " + super.getValor());
		System.out.println("");
		
		return "";
	}
	
	
}
