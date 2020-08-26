package Compra;

import java.util.Scanner;

import HistoricoCompraDAO.HistoricoCompraDAO;
import MenuCliente.MenuClienteLoja;
import ProdutoDAO.ProdutoDAO;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;

public class CompraProdutoLoja implements InterfaceComandoCompra {

	PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	Scanner scanner = new Scanner(System.in);

	public void compra() {

		System.out.println("Digite o nome do produto que você deseja: ");
		String nome_produto = scanner.next();

		System.out.println("Digite a quantidade que você deseja: ");
		int quantidade = scanner.nextInt();

		int quantidade_produto_loja = new ProdutoDAO().verificaProdutoLoja(nome_produto);

		if (quantidade > 0 && quantidade <= quantidade_produto_loja) {

			double valor_compra = new ProdutoDAO().valor_pedido_loja(nome_produto, quantidade);
			new ProdutoDAO().retirarProdutoLoja(nome_produto, quantidade);

			int opcao_compra = 0;

			if (usuario.getCartao() != null && usuario.getCartao().getStatus().toString() == "Liberado") {

				System.out.println("1- Se você deseja comprar com o cartão especial");
				System.out.println("0- Se você deseja comprar apenas com seu saldo");
				opcao_compra = scanner.nextInt();
			}

			if (opcao_compra == 1) {

				CompraProduto comprar = new CompraProduto(usuario, MenuClienteLoja.getLoja(), "com cartao",
						valor_compra, null);
				comprar.compra(true);

				new HistoricoCompraDAO().adicionarCompra(comprar);

			} else {

				String tipo_entrega = null;

				System.out.println("As formas de fretes são");
				System.out.println("1- PAC");
				System.out.println("2- Sedex");

				int frete = scanner.nextInt();

				if (frete == 1) {
					tipo_entrega = "PAC";
				}
				if (frete == 2) {
					tipo_entrega = "Sedex";
				}

				CompraProduto comprar = new CompraProduto(usuario, MenuClienteLoja.getLoja(), "sem cartao",
						valor_compra, tipo_entrega);
				comprar.compra(false);

				new HistoricoCompraDAO().adicionarCompra(comprar);
			}
		} else {
			System.out.println("Esse produto ou quantidade é invalida");
		}
	}

}
