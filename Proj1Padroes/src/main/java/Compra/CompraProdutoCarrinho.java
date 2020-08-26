package Compra;

import java.util.Scanner;

import CarrinhoDAO.CarrinhoDAODecorator;
import HistoricoCompraDAO.HistoricoCompraDAO;
import MenuCliente.MenuClienteLoja;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;

public class CompraProdutoCarrinho implements InterfaceComandoCompra {

	PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	Scanner scanner = new Scanner(System.in);

	public void compra() {

		int opcao_compra = 0;

		double valor_compra = new CarrinhoDAODecorator().verificaValorCarrinho();

		if (usuario.getCartao() != null && usuario.getCartao().getStatus().toString() == "Liberado") {

			System.out.println("1- Se você deseja comprar com o cartão especial");
			System.out.println("0- Se você deseja comprar apenas com seu saldo");
			opcao_compra = scanner.nextInt();
		}

		if (opcao_compra == 1) {

			CompraProduto comprar = new CompraProduto(usuario, MenuClienteLoja.getLoja(), "com cartao",
					valor_compra, null);
			boolean verificar_compra = comprar.compra(true);

			new HistoricoCompraDAO().adicionarCompra(comprar);

			if (verificar_compra == true)
				new CarrinhoDAODecorator().eliminarProdutosCompra();

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
			boolean verificar_compra = comprar.compra(false);

			new HistoricoCompraDAO().adicionarCompra(comprar);

			if (verificar_compra == true)
				new CarrinhoDAODecorator().eliminarProdutosCompra();
		}

	}

}
