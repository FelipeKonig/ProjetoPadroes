package Usuario;

import java.util.ArrayList;

import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;
import UsuarioDAO.Observable;
import UsuarioDAO.Observer;

public class PessoaJuridica extends Pessoa implements Observer {

	private String cnpj, tipo_empresa;
	private ArrayList<ProdutoDuravel> list_produtos_duraveis;
	private ArrayList<ProdutoNaoDuravel> list_produtos_nao_duraveis;
	private ArrayList<KitProduto> list_kits;

	public PessoaJuridica criarCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public PessoaJuridica criarTipo_empresa(String tipo_empresa) {
		this.tipo_empresa = tipo_empresa;
		return this;
	}

	public void notificaLojaClienteSeguir(Observable loja, String message) {
		System.out.println("Obrigado por seguir a nossa loja!");
		System.out.println("Nós da " + this.nome + " ficamos gratos");
	}

	public void notificaLojaClienteNaoSeguir(Observable loja, String message) {
		System.out.println("Sentimos muito, nós da " + this.nome + " esperamos uma experência melhor ");
		System.out.println("da próxima vez!");

	}

	public String getCnpj() {
		return cnpj;
	}

	public String getTipo_empresa() {
		return tipo_empresa;
	}

	public void setTipo_empresa(String tipo_empresa) {
		this.tipo_empresa = tipo_empresa;
	}

	public ArrayList<KitProduto> getList_kits() {
		if (list_kits == null) {
			list_kits= new ArrayList<KitProduto>();
		}
		return list_kits;
	}

	public ArrayList<ProdutoDuravel> getList_produtos_duraveis() {
		if (list_produtos_duraveis == null) {
			list_produtos_duraveis = new ArrayList<ProdutoDuravel>();
		}
		return list_produtos_duraveis;
	}

	public ArrayList<ProdutoNaoDuravel> getList_produtos_nao_duraveis() {
		if (list_produtos_nao_duraveis == null) {
			list_produtos_nao_duraveis = new ArrayList<ProdutoNaoDuravel>();
		}
		return list_produtos_nao_duraveis;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setList_produtos_duraveis(ArrayList<ProdutoDuravel> list_produtos_duraveis) {
		this.list_produtos_duraveis = list_produtos_duraveis;
	}

	public void setList_produtos_nao_duraveis(ArrayList<ProdutoNaoDuravel> list_produtos_nao_duraveis) {
		this.list_produtos_nao_duraveis = list_produtos_nao_duraveis;
	}

	public void setList_kits(ArrayList<KitProduto> list_kits) {
		this.list_kits = list_kits;
	}

	@Override
	public String toString() {
		return nome;
	}

}
