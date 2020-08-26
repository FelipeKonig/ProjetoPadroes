package Carrinho;

import Produto.KitProduto;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;
import UsuarioDAO.UsuarioDAOProxy;

public class RealCarrinho extends Carrinho {

	@Override
	public String getInformacao() {

		new UsuarioDAOProxy();
		PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

		int valor = 0;
		boolean verifica_produtos = false;

		if (usuario.getCarrinho().getProdutos_duraveis().size() > 0) {
			for (int produto = 0; produto < usuario.getCarrinho().getProdutos_duraveis().size(); produto++) {

				System.out.println("");

				System.out.println("Produto: " + usuario.getCarrinho().getProdutos_duraveis().get(produto).getNome());
				System.out.println("Valor: " + usuario.getCarrinho().getProdutos_duraveis().get(produto).getValor());
				System.out.println(
						"Quantidade: " + usuario.getCarrinho().getProdutos_duraveis().get(produto).getQuantidade());

				valor += usuario.getCarrinho().getProdutos_duraveis().get(produto).getValor();

				verifica_produtos = true;
			}
		}
		if (usuario.getCarrinho().getProdutos_nao_duraveis().size() > 0) {

			for (int produto = 0; produto < usuario.getCarrinho().getProdutos_nao_duraveis().size(); produto++) {

				System.out.println("");

				System.out
						.println("Produto: " + usuario.getCarrinho().getProdutos_nao_duraveis().get(produto).getNome());
				System.out
						.println("Valor: " + usuario.getCarrinho().getProdutos_nao_duraveis().get(produto).getValor());
				System.out.println(
						"Quantidade: " + usuario.getCarrinho().getProdutos_nao_duraveis().get(produto).getQuantidade());

				valor += usuario.getCarrinho().getProdutos_nao_duraveis().get(produto).getValor();

				verifica_produtos = true;
			}

		} else if (usuario.getCarrinho().getProdutos_nao_duraveis().size() == 0
				&& usuario.getCarrinho().getProdutos_duraveis().size() == 0) {
			System.out.println("Seu carrinho está sem nenhum produto");
		}
		
		if (usuario.getCarrinho().getKits().size() > 0) {
			
			System.out.println("");
			
			for (KitProduto kit : usuario.getCarrinho().getKits()) {
				kit.toString();
				valor += kit.getValor();
				verifica_produtos = true;
			}
		}
		
		if (verifica_produtos == true) 
			System.out.println("O valor total dos produtos em seu carrinho é " + valor + " reais");
		

		System.out.println("");
		return "";

	}

}
