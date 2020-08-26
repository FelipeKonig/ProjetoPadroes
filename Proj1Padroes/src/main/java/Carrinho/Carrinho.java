package Carrinho;

import java.util.ArrayList;

import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;

public class Carrinho {
	private ArrayList<ProdutoDuravel> produtos_duraveis;
	private ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis;
	private ArrayList<KitProduto> kits;
	private String informacao;

	public Carrinho() {

	}

	public ArrayList<KitProduto> getKits() {
		return kits;
	}

	public void setKits(ArrayList<KitProduto> kits) {
		this.kits = kits;
	}

	public ArrayList<ProdutoDuravel> getProdutos_duraveis() {
		return produtos_duraveis;
	}

	public void setProdutos_duraveis(ArrayList<ProdutoDuravel> produtos_duraveis) {
		this.produtos_duraveis = produtos_duraveis;
	}

	public ArrayList<ProdutoNaoDuravel> getProdutos_nao_duraveis() {
		return produtos_nao_duraveis;
	}

	public void setProdutos_nao_duraveis(ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis) {
		this.produtos_nao_duraveis = produtos_nao_duraveis;
	}

	public String getInformacao() {
		return informacao;
	}

}
