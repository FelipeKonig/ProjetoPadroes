package MenuLoja;

import java.util.Scanner;

import HistoricoCompraDAO.HistoricoCompraDAO;
import MenuGeral.MenuPrincipal;
import ProdutoDAO.ProdutoDAO;
import Usuario.PessoaJuridica;
import Usuario.UsuarioLogado;

public class MenuPrincipalLoja {

	private PessoaJuridica loja = (PessoaJuridica) UsuarioLogado.getUsuario_logado();
	private Scanner scanner;

	public void menuGeralLoja() {

		int opcao = 0;

		scanner = new Scanner(System.in);

		System.out.println(loja.getNome());
		System.out.println("1- Cadastrar produto");
		System.out.println("2- Ver seus produtos");
		System.out.println("3- Cadastrar kit");
		System.out.println("4- Ver seus kits");
		System.out.println("5- Ver histórico de vendas");

		System.out.println("0- Sair");
		System.out.println("Selecione sua opção:");

		opcao = scanner.nextInt();

		if (opcao == 1)
			new ProdutoDAO().adicionarProduto();

		if (opcao == 2)
			new ProdutoDAO().mostrarProdutosLoja();

		if (opcao == 3)
			new ProdutoDAO().adicionarKit();

		if (opcao == 4)
			new ProdutoDAO().mostrarKitsLoja();
		
		if (opcao == 5)
			verHistoricoVendas();

		if (opcao == 0)
			new MenuPrincipal().menuPrincipal();

	}

	private void verHistoricoVendas() {
		System.out.println("Histórico de vendas:");

		new HistoricoCompraDAO().mostrarHistorico(loja);
		menuGeralLoja();
	}

}
