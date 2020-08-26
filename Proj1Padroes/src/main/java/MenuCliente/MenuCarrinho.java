package MenuCliente;

import java.util.Scanner;

import Carrinho.NullCarrinho;
import CarrinhoDAO.CarrinhoDAODecorator;
import Compra.CompraProdutoCarrinho;
import Compra.ExecutorCompra;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;

public class MenuCarrinho {

	PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	Scanner scanner = new Scanner(System.in);

	public void menuCarrinho() {

		int opcao = 0;

		System.out.println("1- Ver meu carrinho");
		System.out.println("2- Retirar produto ou kit do seu carrinho");
		System.out.println("3- Para comprar o carrinho");
		System.out.println("0- Sair");

		opcao = scanner.nextInt();

		if (opcao == 1)
			new CarrinhoDAODecorator().verProdutosCarrinho();

		if (opcao == 2) {
			System.out.println("Digite o nome do produto que você deseja retirar: ");
			String nome_produto = scanner.next();

			System.out.println("Digite a quantidade que você deseja retirar: ");
			System.out.println("OBS: Se você digitar uma quantidade maior do que a que você possui no carrinho, ");
			System.out.println("será excluídos todos os produtos selecionados");
			int quantidade = scanner.nextInt();

			new CarrinhoDAODecorator().retirarProdutoCarrinho(nome_produto, quantidade);
		}

		if (opcao == 3) {
			
			new CarrinhoDAODecorator().verificarProdutosCompra();

			if (new CarrinhoDAODecorator().verificaValorCarrinho() > 0) {
				
				ExecutorCompra exec = new ExecutorCompra();
				exec.realizarCompra(new CompraProdutoCarrinho());
				
			} else {
				System.out.println(new NullCarrinho().getInformacao());
			}

			System.out.println("");
			System.out.println("Compra realizada com sucesso");
			System.out.println("");
			
			new MenuCarrinho().menuCarrinho();
		}

		if (opcao == 0)
			new MenuPrincipalCliente().menuGeralCliente();
	}

}
