package MenuCliente;

import java.util.Scanner;

import CarrinhoDAO.CarrinhoDAODecorator;
import Compra.CompraProdutoLoja;
import Compra.ExecutorCompra;
import ProdutoDAO.ProdutoDAO;
import Usuario.PessoaJuridica;
import UsuarioDAO.ClienteDAO;
import UsuarioDAO.UsuarioDAOProxy;

public class MenuClienteLoja {

	private static PessoaJuridica loja;

	Scanner scanner = new Scanner(System.in);

	public void menuGeralClienteLoja() {

		int opcao = 0;

		System.out.println("");

		System.out.println("1- Ver, colocar no carrinho ou comprar os produtos ou kits");
		System.out.println("2- Começar a seguir a loja");
		System.out.println("3- Deixar de seguir a loja");
		System.out.println("0- Voltar");
		System.out.println("Selecione sua opção:");

		opcao = scanner.nextInt();

		if (opcao == 1)
			new ProdutoDAO().mostrarProdutosLojaCliente(loja);

		if (opcao == 2)
			new ClienteDAO().ComecarSeguirLoja(loja);

		if (opcao == 3)
			new ClienteDAO().DeixarSeguirLoja(loja);

		if (opcao == 0)
			new MenuPrincipalCliente().menuGeralCliente();

	}

	public void menuClienteProduto() {

		System.out.println("1- Se você deseja colocar algum produto ou kit no carrinho ");
		System.out.println("2- Se você deseja comprar algum produto ou kit");
		System.out.println("3- Se você deseja visualizar o conteúdo de algum kit");
		System.out.println("0- Se você deseja voltar");
		System.out.println("Selecione a sua opção: ");
		int opcao = scanner.nextInt();

		if (opcao == 1)
			colocarProdutoCarrinho();

		if (opcao == 2)
			comprar_produto();
		
		if (opcao == 3) {
			visualizar_kit();
		}

		if (opcao == 0)
			new MenuClienteLoja().menuGeralClienteLoja();

	}

	private void visualizar_kit() {
		System.out.println("");
		System.out.println("1- Digite o nome do kit: ");
		String nome = scanner.next();
		
		new ProdutoDAO().verificaProdutoLoja(nome);

		System.out.println("");
		new MenuClienteLoja().menuGeralClienteLoja();		
	}

	public void menuClienteEscolherLoja() {

		System.out.println("");

		System.out.println("Digite o nome da loja que você deseja entrar: ");
		String selecionar_loja = scanner.next();

		loja = new UsuarioDAOProxy().acessarLoja(selecionar_loja);

		if (loja == null) {
			new MenuPrincipalCliente().menuGeralCliente();
		}else {
			new MenuClienteLoja().menuGeralClienteLoja();
		}
	}

	private void colocarProdutoCarrinho() {

		System.out.println("Digite o nome do produto ou kit que você deseja: ");
		String nome_produto = scanner.next();

		System.out.println("Digite a quantidade que você deseja: ");
		int quantidade = scanner.nextInt();

		if (quantidade > 0) {

			int quantidade_carrinho_usuario = new CarrinhoDAODecorator().verificaProdutoCarrinho(nome_produto);

			int quantidade_produto_loja = new ProdutoDAO().verificaProdutoLoja(nome_produto);

			int soma = quantidade_produto_loja - quantidade_carrinho_usuario;

			System.out.println("Quantidade pedida: " + quantidade);
			System.out.println("Quantidade no carrinho do cliente: " + quantidade_carrinho_usuario);
			System.out.println("Quantidade na loja: " + quantidade_produto_loja);

			if (soma > 0 && quantidade <= soma) {
				new ProdutoDAO().enviarProdutoCarrinho(nome_produto, quantidade);
			}

			if (soma < 0) {
				System.out.println("A quantidade que está loja tem do produto selecionado não permite você pôr mais");
				System.out.println(" dele em seu carrinho");
				System.out.println("");

				new MenuClienteLoja().menuGeralClienteLoja();
			}

			if (quantidade > soma) {
				System.out.println("Você está tentando adicionar uma quantidade maior do que está loja permite desse");
				System.out.println(" produto ou o produto não existe");
				System.out.println("");

				new MenuClienteLoja().menuGeralClienteLoja();
			}

		}
	}

	private void comprar_produto() {
		
		ExecutorCompra exec = new ExecutorCompra();
		exec.realizarCompra(new CompraProdutoLoja());

		System.out.println("");
		new MenuClienteLoja().menuGeralClienteLoja();

	}

	public static PessoaJuridica getLoja() {
		return loja;
	}

}
