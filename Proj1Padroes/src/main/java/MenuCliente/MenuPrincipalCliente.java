package MenuCliente;

import java.util.Scanner;

import CartaoCliente.Cartao;
import HistoricoCompraDAO.HistoricoCompraDAO;
import MenuGeral.MenuPrincipal;
import ProdutoDAO.ProdutoDAO;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;
import UsuarioDAO.UsuarioDAOProxy;

public class MenuPrincipalCliente {

	PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	Scanner scanner = new Scanner(System.in);

	public void menuGeralCliente() {

		int opcao = 0;

		System.out.println("1- Ver lojas");
		System.out.println("2- Entrar em uma loja");
		System.out.println("3- Procurar produto");
		System.out.println("4- Comprar/atualizar cartão especial");
		System.out.println("5- Comprar versão premium");
		System.out.println("6- Entrar em meu carrinho");
		System.out.println("7- Para ver seu saldo");
		System.out.println("8- Ver lojas que estou seguindo");
		System.out.println("9- Ver seu histórico de compras");
		System.out.println("0- Sair");
		System.out.println("Selecione sua opção:");

		opcao = scanner.nextInt();

		if (opcao == 1)
			new UsuarioDAOProxy().mostrarLojas();

		if (opcao == 2)
			new MenuClienteLoja().menuClienteEscolherLoja();

		if (opcao == 3) {
			System.out.println("");

			System.out.println("Digite o nome do produto que você procura: ");
			String nome_produto = scanner.next();

			System.out.println("");

			new ProdutoDAO().BuscarProduto(nome_produto);
		}

		if (opcao == 4)
			comprarCartao();

		if (opcao == 5)
			comprarVersaoPremium();

		if (opcao == 6)
			new MenuCarrinho().menuCarrinho();

		if (opcao == 7)
			verSaldo();
		
		if (opcao == 8) 
			verLojasSeguindo();
		
		if (opcao == 9) 
			verHistorico();

		if (opcao == 0) 
			new MenuPrincipal().menuPrincipal();
		
			
	}
	
	private void verHistorico() {
		
		System.out.println("Histórico de compras:");
		new HistoricoCompraDAO().mostrarHistorico(usuario);
		
		menuGeralCliente();
	}

	private void verLojasSeguindo() { 
		new UsuarioDAOProxy().verLojasSeguindo();
	}
		

	private void comprarVersaoPremium() {
		int opcao = 0;

		if (usuario.getSaldo() > 30) {
			System.out.println("Seu saldo é de " + usuario.getSaldo());
			System.out.println("A compra da versão premium é 30 reais");
			System.out.println("1- para comprar");
			System.out.println("2- para não comprar");

			opcao = scanner.nextInt();

			if (opcao == 1) {
				usuario.setSaldo(usuario.getSaldo() - 30);
				usuario.setVersao_premium(true);

				System.out.println("Sua versão premium foi comprada com sucesso, agora você terá um desconto");
				System.out.println("em cada compra");

			} else {
				System.out.println("Você não comprou a versão premium");

			}
		} else {
			System.out.println("Você não tem saldo o suficiente para comprar a versão premium");
			System.out.println("OBS: o cartão especial é exclusivo para compras");
		}

		System.out.println("");

		menuGeralCliente();
	}

	private void comprarCartao() {

		int opcao = 0;

		if (usuario.getSaldo() >= 30) {
			System.out.println("Seu saldo é de " + usuario.getSaldo());
			System.out.println("A compra do cartão especial é 30 reais");
			System.out.println("Se você já tem seu cartão e ele está liberado ou bloqueado");
			System.out.println("será acrescentado 50 reais no saldo dele");
			System.out.println("1- para comprar");
			System.out.println("2- para não comprar");

			opcao = scanner.nextInt();

			if (opcao == 1) {

				if (usuario.getCartao() == null) {

					Cartao cartao = new Cartao();
					usuario.setCartao(cartao);
				}

				usuario.getCartao().ativarCartao(usuario);

			} else {
				System.out.println("Você não comprou o cartão especial");

			}
		} else {
			System.out.println("Você não tem saldo o suficiente para comprar o cartão");
		}

		System.out.println("");

		menuGeralCliente();

	}

	private void verSaldo() {

		System.out.println("Seu saldo sem o cartão especial é de " + usuario.getSaldo() + " reais");

		if (usuario.getCartao() != null)
			System.out.println("Seu saldo do cartão especial é de " + usuario.getCartao().getValor() + " reais");

		System.out.println("");

		menuGeralCliente();
	}
}
