package CarrinhoDAO;

import java.util.ArrayList;

import Carrinho.Carrinho;
import MenuCliente.MenuCarrinho;
import MenuCliente.MenuClienteLoja;
import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;

public class CarrinhoDAODecorator implements InterfaceCarrinhoDAO {

	PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	public CarrinhoDAODecorator() {
		verificaCarrinhoUsuario();
	}
	
	public void adicionarProdutoDuravelCarrinho(ProdutoDuravel produto, int quantidade) {

		new CarrinhoDAO().adicionarProdutoDuravelCarrinho(produto, quantidade);
	}

	public void adicionarProdutoNaoDuravelCarrinho(ProdutoNaoDuravel produto, int quantidade) {
		
		new CarrinhoDAO().adicionarProdutoNaoDuravelCarrinho(produto, quantidade);

	}

	public void adicionarProdutoKit(KitProduto kit_encontrado, int quantidade) {

		new CarrinhoDAO().adicionarProdutoKit(kit_encontrado, quantidade);
	}

	public void retirarProdutoCarrinho(String nome_produto, int quantidade) {

		new CarrinhoDAO().retirarProdutoCarrinho(nome_produto, quantidade);

		new MenuCarrinho().menuCarrinho();

	}

	public void verProdutosCarrinho() {

		new CarrinhoDAO().verProdutosCarrinho();
		
		new MenuCarrinho().menuCarrinho();

	}

	public int verificaProdutoCarrinho(String nome_produto) {
		
		return new CarrinhoDAO().verificaProdutoCarrinho(nome_produto);
	}

	public double verificaValorCarrinho() {
		
		return new CarrinhoDAO().verificaValorCarrinho();
	}

	public boolean verificarProdutosCompra() {

		if (MenuClienteLoja.getLoja() == null) {
			System.out.println("Primeiro faça um pedido");
			return false;
		}
		
		boolean verifica = new CarrinhoDAO().verificarProdutosCompra();
		
		if (verifica == false) {
			System.out.println("");
			System.out.println("Caso queira comprar os produtos de outra loja, entre nela novamente e ");
			System.out.println("posteriormente volte ao seu carrinho, assim será verificado o pedido com ");
			System.out.println("os produtos da loja desejada, caso contrário, tire esses produtos do seu carrinho");
		}
		return verifica;
	}

	public void eliminarProdutosCompra() {
		
		new CarrinhoDAO().eliminarProdutosCompra();
		
		new MenuCarrinho().menuCarrinho();
	}

	private void verificaCarrinhoUsuario() {

		if (usuario.getCarrinho() == null) {
			Carrinho carrinho = new Carrinho();
			carrinho.setProdutos_duraveis(new ArrayList<ProdutoDuravel>());
			carrinho.setProdutos_nao_duraveis(new ArrayList<ProdutoNaoDuravel>());
			carrinho.setKits(new ArrayList<KitProduto>());
			usuario.setCarrinho(carrinho);
		} else {
			if (usuario.getCarrinho().getProdutos_duraveis() == null) {
				usuario.getCarrinho().setProdutos_duraveis(new ArrayList<ProdutoDuravel>());
			}
			if (usuario.getCarrinho().getProdutos_nao_duraveis() == null) {
				usuario.getCarrinho().setProdutos_nao_duraveis(new ArrayList<ProdutoNaoDuravel>());
			}
			if (usuario.getCarrinho().getKits() == null) {
				usuario.getCarrinho().setKits(new ArrayList<KitProduto>());
			}
		}
	}

}
