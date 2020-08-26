package ProdutoDAO;

import java.util.ArrayList;
import java.util.Scanner;

import CarrinhoDAO.CarrinhoDAODecorator;
import MenuCliente.MenuClienteLoja;
import MenuCliente.MenuPrincipalCliente;
import MenuLoja.MenuPrincipalLoja;
import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;
import Usuario.PessoaJuridica;
import Usuario.UsuarioLogado;
import UsuarioDAO.UsuarioDAOProxy;

public class ProdutoDAO implements InterfaceProdutoDAO {

	private String nome, categoria, data_criacao, descricao, tempo_garantia, data_validade;
	private float valor;
	private int quantidade;

	Scanner scanner = new Scanner(System.in);
	private ArrayList<PessoaJuridica> lojas;

	public void adicionarProduto() {

		System.out.println("1- O produto é durável");
		System.out.println("2- O produto não é durável");

		int tipo_produto = scanner.nextInt();

		if (tipo_produto != 1 && tipo_produto != 2) {
			while (true) {

				System.out.println("Digite uma opção válida");

				tipo_produto = scanner.nextInt();

				if (tipo_produto == 1 || tipo_produto == 2) {
					break;
				}

			}
		}

		if (tipo_produto == 1) {

			cadastroProdutoDuravel();

		} else {

			cadastroProdutoNaoDuravel();

		}

		System.out.println("");

		new MenuPrincipalLoja().menuGeralLoja();

	}

	public void mostrarProdutosLoja() {

		PessoaJuridica loja_logada = (PessoaJuridica) UsuarioLogado.getUsuario_logado();

		ArrayList<ProdutoDuravel> produtos_duraveis = null;

		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis = null;

		if (loja_logada.getList_produtos_duraveis().size() > 0) {
			produtos_duraveis = UsuarioDAOProxy.getLoja_acessada().getList_produtos_duraveis();

			System.out.println("Produtos duraveis:");

			for (int i = 0; i < produtos_duraveis.size(); i++) {
				System.out.println("Nome: " + produtos_duraveis.get(i).getNome());
				System.out.println("Categoria: " + produtos_duraveis.get(i).getCategoria());
				System.out.println("Quantidade: " + produtos_duraveis.get(i).getQuantidade());
				System.out.println("Valor: " + produtos_duraveis.get(i).getValor());

			}
		} else {
			System.out.println("Sua loja não tem produtos duráveis");
		}

		System.out.println("");

		if (loja_logada.getList_produtos_nao_duraveis().size() > 0) {
			produtos_nao_duraveis = UsuarioDAOProxy.getLoja_acessada().getList_produtos_nao_duraveis();

			System.out.println("Produtos não duraveis:");

			for (int i = 0; i < produtos_nao_duraveis.size(); i++) {
				System.out.println("Nome: " + produtos_nao_duraveis.get(i).getNome());
				System.out.println("Categoria: " + produtos_nao_duraveis.get(i).getCategoria());
				System.out.println("Quantidade: " + produtos_nao_duraveis.get(i).getQuantidade());
				System.out.println("Valor: " + produtos_nao_duraveis.get(i).getValor());
			}
		} else {
			System.out.println("Sua loja não tem produtos não duráveis");
		}

		System.out.println("");

		new MenuPrincipalLoja().menuGeralLoja();

	}

	public void BuscarProduto(String nome_produto) {
		lojas = UsuarioDAOProxy.getLojas();

		boolean verifica_existe = false;

		for (int i = 0; i < lojas.size(); i++) {
			for (int indice_produto = 0; indice_produto < lojas.get(i).getList_produtos_duraveis()
					.size(); indice_produto++) {
				if (lojas.get(i).getList_produtos_duraveis().get(indice_produto).getNome()
						.contentEquals(nome_produto)) {
					System.out.println("Produto " + nome_produto + " encontrado");
					System.out.println("Loja: " + lojas.get(i).getNome());
					System.out.println(
							"Valor: " + lojas.get(i).getList_produtos_duraveis().get(indice_produto).getValor());
					System.out.println("Quantidade: "
							+ lojas.get(i).getList_produtos_duraveis().get(indice_produto).getQuantidade());

					System.out.println("");

					if (verifica_existe == false)
						verifica_existe = true;

				}
			}

			for (int indice_produto = 0; indice_produto < lojas.get(i).getList_produtos_nao_duraveis()
					.size(); indice_produto++) {
				if (lojas.get(i).getList_produtos_nao_duraveis().get(indice_produto).getNome()
						.contentEquals(nome_produto)) {
					System.out.println("Produto " + nome_produto + " encontrado");
					System.out.println("Loja: " + lojas.get(i).getNome());
					System.out.println(
							"Valor: " + lojas.get(i).getList_produtos_nao_duraveis().get(indice_produto).getValor());
					System.out.println("Quantidade: "
							+ lojas.get(i).getList_produtos_nao_duraveis().get(indice_produto).getQuantidade());

					System.out.println("");

					if (verifica_existe == false)
						verifica_existe = true;
				}
			}
		}

		if (verifica_existe == false)
			System.out.println("Esse produto não contém em nenhuma loja");

		System.out.println("");

		new MenuPrincipalCliente().menuGeralCliente();

	}

	private void cadastroProdutoDuravel() {

		PessoaJuridica loja_logada = (PessoaJuridica) UsuarioLogado.getUsuario_logado();

		System.out.println("Digite o nome do produto: ");
		nome = scanner.next();

		System.out.println("Digite a categoria do produto: ");
		categoria = scanner.next();

		System.out.println("Digite a data de criação do produto: ");
		data_criacao = scanner.next();

		System.out.println("Digite uma descrição para o produto: ");
		descricao = scanner.next();

		System.out.println("Digite o tempo de garantia do produto: ");
		tempo_garantia = scanner.next();

		System.out.println("Digite o valor do produto: ");
		valor = scanner.nextInt();

		System.out.println("Digite a quantidade: ");
		quantidade = scanner.nextInt();

		ProdutoDuravel produto = new ProdutoDuravel(nome, categoria, data_criacao, descricao, quantidade, valor,
				tempo_garantia);

		loja_logada.getList_produtos_duraveis().add(produto);

		System.out.println("Produto cadastrado");

	}

	private void cadastroProdutoNaoDuravel() {

		PessoaJuridica loja_logada = (PessoaJuridica) UsuarioLogado.getUsuario_logado();

		System.out.println("Digite o nome do produto: ");
		nome = scanner.next();

		System.out.println("Digite a categoria do produto: ");
		categoria = scanner.next();

		System.out.println("Digite a data de criação do produto: ");
		data_criacao = scanner.next();

		System.out.println("Digite uma descrição para o produto: ");
		descricao = scanner.next();

		System.out.println("Digite o tempo de validade do produto: ");
		data_validade = scanner.next();

		System.out.println("Digite o valor do produto: ");
		valor = scanner.nextInt();

		System.out.println("Digite a quantidade: ");
		quantidade = scanner.nextInt();

		ProdutoNaoDuravel produto = new ProdutoNaoDuravel(nome, categoria, data_criacao, descricao, quantidade, valor,
				data_validade);

		loja_logada.getList_produtos_nao_duraveis().add(produto);

		System.out.println("Produto cadastrado");
	}

	public void mostrarProdutosLojaCliente(PessoaJuridica loja) {

		ArrayList<ProdutoDuravel> produtos_duraveis = null;

		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis = null;

		if (loja.getList_produtos_duraveis().size() > 0) {
			produtos_duraveis = loja.getList_produtos_duraveis();

			System.out.println("Produtos duraveis:");

			for (int i = 0; i < produtos_duraveis.size(); i++) {
				System.out.println("Nome: " + produtos_duraveis.get(i).getNome());
				System.out.println("Categoria: " + produtos_duraveis.get(i).getCategoria());
				System.out.println("Valor: " + produtos_duraveis.get(i).getValor());
				System.out.println("Quantidade: " + produtos_duraveis.get(i).getQuantidade());

			}
		} else {
			System.out.println("A loja não tem produtos duráveis");
		}

		System.out.println("");

		if (loja.getList_produtos_nao_duraveis().size() > 0) {
			produtos_nao_duraveis = loja.getList_produtos_nao_duraveis();

			System.out.println("Produtos não duraveis:");

			for (int i = 0; i < produtos_nao_duraveis.size(); i++) {
				System.out.println("Nome: " + produtos_nao_duraveis.get(i).getNome());
				System.out.println("Categoria: " + produtos_nao_duraveis.get(i).getCategoria());
				System.out.println("Valor: " + produtos_nao_duraveis.get(i).getValor());
				System.out.println("Quantidade: " + produtos_nao_duraveis.get(i).getQuantidade());
			}
		} else {
			System.out.println("A loja não tem produtos não duráveis");
		}

		System.out.println("");

		if (loja.getList_kits().size() > 0) {
			for (KitProduto kit : loja.getList_kits()) {
				kit.toString();
			}
		} else {
			System.out.println("A loja não tem kits");
		}

		System.out.println("");

		new MenuClienteLoja().menuClienteProduto();

	}

	public double valor_pedido_loja(String nome_produto, int quantidade) {
		PessoaJuridica loja = MenuClienteLoja.getLoja();
		ArrayList<ProdutoDuravel> produtos_duraveis = loja.getList_produtos_duraveis();
		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis = loja.getList_produtos_nao_duraveis();
		ArrayList<KitProduto> kits = loja.getList_kits();

		double valor_pedido = 0;

		for (int i = 0; i < produtos_duraveis.size(); i++) {
			if (produtos_duraveis.get(i).getNome().contentEquals(nome_produto)) {
				ProdutoDuravel produto = produtos_duraveis.get(i);

				if (quantidade > produto.getQuantidade())
					quantidade = produto.getQuantidade();

				valor_pedido = produto.getValor() * quantidade;

			}

		}

		for (int i = 0; i < produtos_nao_duraveis.size(); i++) {
			if (produtos_nao_duraveis.get(i).getNome().contentEquals(nome_produto)) {
				ProdutoNaoDuravel produto = produtos_nao_duraveis.get(i);

				if (quantidade > produto.getQuantidade())
					quantidade = produto.getQuantidade();

				valor_pedido = produto.getValor() * quantidade;

			}
		}

		for (int i = 0; i < kits.size(); i++) {
			if (kits.get(i).getNome().contentEquals(nome_produto)) {
				KitProduto produto = kits.get(i);

				if (quantidade > produto.getQuantidade())
					quantidade = produto.getQuantidade();

				valor_pedido = produto.getValor() * quantidade;

			}
		}

		return valor_pedido;

	}

	public void retirarProdutoLoja(String nome_produto, int quantidade) {

		PessoaJuridica loja = MenuClienteLoja.getLoja();
		ArrayList<ProdutoDuravel> produtos_duraveis = loja.getList_produtos_duraveis();
		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis = loja.getList_produtos_nao_duraveis();
		ArrayList<KitProduto> kits = loja.getList_kits();

		boolean verifica_produto = false;

		for (int i = 0; i < produtos_duraveis.size(); i++) {
			if (produtos_duraveis.get(i).getNome().contentEquals(nome_produto)) {
				ProdutoDuravel produto = produtos_duraveis.get(i);

				if (loja.getList_produtos_duraveis().get(i).getQuantidade() > 0) {

					verifica_produto = true;

					loja.getList_produtos_duraveis().get(i).setQuantidade(produto.getQuantidade() - quantidade);

					if (loja.getList_produtos_duraveis().get(i).getQuantidade() == 0)
						loja.getList_produtos_duraveis().remove(i);

				}

			}

		}

		for (int i = 0; i < produtos_nao_duraveis.size(); i++) {
			if (produtos_nao_duraveis.get(i).getNome().contentEquals(nome_produto)) {
				ProdutoNaoDuravel produto = produtos_nao_duraveis.get(i);

				if (loja.getList_produtos_nao_duraveis().get(i).getQuantidade() > 0) {

					verifica_produto = true;

					loja.getList_produtos_nao_duraveis().get(i).setQuantidade(produto.getQuantidade() - quantidade);

					if (loja.getList_produtos_nao_duraveis().get(i).getQuantidade() == 0)
						loja.getList_produtos_nao_duraveis().remove(i);

				}

			}
		}

		for (int i = 0; i < kits.size(); i++) {
			if (kits.get(i).getNome().contentEquals(nome_produto)) {
				KitProduto produto = kits.get(i);

				if (loja.getList_kits().get(i).getQuantidade() > 0) {

					verifica_produto = true;

					loja.getList_kits().get(i).setQuantidade(produto.getQuantidade() - quantidade);

					if (loja.getList_kits().get(i).getQuantidade() == 0)
						loja.getList_kits().remove(i);

				}

			}
		}

		if (verifica_produto == false)
			System.out.println("O produto escolhido não foi encontrado");

	}

	public void enviarProdutoCarrinho(String nome_produto, int quantidade) {

		PessoaJuridica loja = MenuClienteLoja.getLoja();
		ArrayList<ProdutoDuravel> produtos_duraveis = loja.getList_produtos_duraveis();
		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis = loja.getList_produtos_nao_duraveis();

		boolean verifica_produto = false;

		for (int i = 0; i < produtos_duraveis.size(); i++) {
			if (produtos_duraveis.get(i).getNome().contentEquals(nome_produto)) {
				ProdutoDuravel produto = produtos_duraveis.get(i);

				if (loja.getList_produtos_duraveis().get(i).getQuantidade() > 0) {

					verifica_produto = true;

					new CarrinhoDAODecorator().adicionarProdutoDuravelCarrinho(produto, quantidade);
				}

			}

		}

		for (int i = 0; i < produtos_nao_duraveis.size(); i++) {
			if (produtos_nao_duraveis.get(i).getNome().contentEquals(nome_produto)) {
				ProdutoNaoDuravel produto = produtos_nao_duraveis.get(i);

				if (loja.getList_produtos_nao_duraveis().get(i).getQuantidade() > 0) {

					verifica_produto = true;
					new CarrinhoDAODecorator().adicionarProdutoNaoDuravelCarrinho(produto, quantidade);

				}
			}
		}

		for (KitProduto kit : loja.getList_kits()) {
			if (kit.getNome().contentEquals(nome_produto)) {
				KitProduto kit_encontrado = kit;

				if (kit.getQuantidade() > 0) {
					verifica_produto = true;
					new CarrinhoDAODecorator().adicionarProdutoKit(kit_encontrado, quantidade);
				}
			}
		}

		if (verifica_produto == false)
			System.out.println("O produto escolhido não foi encontrado");

		new MenuClienteLoja().menuClienteProduto();
	}

	public int verificaProdutoLoja(String nome_produto) {

		PessoaJuridica loja = MenuClienteLoja.getLoja();

		int quantidade = 0;

		for (ProdutoDuravel produto : loja.getList_produtos_duraveis()) {
			if (produto.getNome().contains(nome_produto)) {
				quantidade = produto.getQuantidade();
			}
		}

		for (ProdutoNaoDuravel produto : loja.getList_produtos_nao_duraveis()) {
			if (produto.getNome().contains(nome_produto)) {
				quantidade = produto.getQuantidade();
			}
		}

		for (KitProduto kit : loja.getList_kits()) {
			if (kit.getNome().contains(nome_produto)) {
				quantidade = kit.getQuantidade();
			}
		}
		return quantidade;

	}

	public void retirarProdutoPedidoLoja(ArrayList<ProdutoDuravel> produtos_duraveis,
			ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis, ArrayList<KitProduto> kits) {

		PessoaJuridica loja = MenuClienteLoja.getLoja();

		if (produtos_duraveis != null) {

			for (int i = 0; i < produtos_duraveis.size(); i++) {
				ProdutoDuravel produto_remover = produtos_duraveis.get(i);

				for (int indice_produto = 0; indice_produto < loja.getList_produtos_duraveis()
						.size(); indice_produto++) {
					ProdutoDuravel produto = loja.getList_produtos_duraveis().get(i);

					if (produto.getNome().contentEquals(produto_remover.getNome())) {

						loja.getList_produtos_duraveis().get(indice_produto)
								.setQuantidade(loja.getList_produtos_duraveis().get(indice_produto).getQuantidade()
										- produto_remover.getQuantidade());

						if (produto.getQuantidade() == 0)
							loja.getList_produtos_duraveis().remove(produto);

					}

				}

			}
		}

		if (produtos_nao_duraveis != null) {

			for (int i = 0; i < produtos_nao_duraveis.size(); i++) {
				ProdutoNaoDuravel produto_remover = produtos_nao_duraveis.get(i);

				for (int indice_produto = 0; indice_produto < loja.getList_produtos_nao_duraveis()
						.size(); indice_produto++) {
					ProdutoNaoDuravel produto = loja.getList_produtos_nao_duraveis().get(i);

					if (produto.getNome().contentEquals(produto_remover.getNome())) {

						loja.getList_produtos_nao_duraveis().get(indice_produto)
								.setQuantidade(loja.getList_produtos_nao_duraveis().get(indice_produto).getQuantidade()
										- produto_remover.getQuantidade());

						if (produto.getQuantidade() == 0)
							loja.getList_produtos_nao_duraveis().remove(produto);

					}

				}

			}
		}

		if (kits != null) {

			for (int i = 0; i < kits.size(); i++) {
				KitProduto kit_remover = kits.get(i);

				for (int indice_produto = 0; indice_produto < loja.getList_kits().size(); indice_produto++) {
					KitProduto kit = loja.getList_kits().get(i);

					if (kit.getNome().contentEquals(kit_remover.getNome())) {

						loja.getList_kits().get(indice_produto).setQuantidade(
								loja.getList_kits().get(indice_produto).getQuantidade() - kit_remover.getQuantidade());

						if (kit.getQuantidade() == 0)
							loja.getList_kits().remove(kit);

					}

				}

			}
		}

		System.out.println("");

	}

	public void adicionarKit() {
		cadastroKit();

	}

	private void cadastroKit() {

		System.out.println("Digite o nome do kit: ");
		nome = scanner.next();

		System.out.println("Digite a categoria do kit: ");
		categoria = scanner.next();

		System.out.println("Digite a data de criação do kit: ");
		data_criacao = scanner.next();

		System.out.println("Digite uma descrição para o kit: ");
		descricao = scanner.next();

		KitProduto kit = new KitProduto(nome, categoria, data_criacao, descricao, 0, 0);
		adicionarProdutosKit(kit);

		new MenuPrincipalLoja().menuGeralLoja();

	}

	private void adicionarProdutosKit(KitProduto kit) {

		PessoaJuridica loja_logada = (PessoaJuridica) UsuarioLogado.getUsuario_logado();

		int quantidade_adicionada = 0, quantidade_produto = 0;

		System.out.println("Digite a quantidade de kits: ");
		quantidade = scanner.nextInt();

		if (quantidade > 0) {
			while (true) {
				System.out.println("0 - Para sair");
				System.out.println("Digite o nome do produto que você deseja aderir");
				nome = scanner.next();

				if (nome.contentEquals("0")) {
					break;
				}

				if (verificaProduto(nome) == true) {
					System.out.println("Digite a quantidade que você:");
					quantidade_produto = scanner.nextInt();

					for (ProdutoDuravel produto : loja_logada.getList_produtos_duraveis()) {
						if (produto.getNome().contentEquals(nome)) {
							if (produto.getQuantidade() >= (quantidade_produto * quantidade)) {
								kit.setQuantidade(kit.getQuantidade() + quantidade);
								kit.getPacote_produtos_duraveis().add(produto);
								produto.setQuantidade(produto.getQuantidade() - (quantidade_produto * quantidade));

								quantidade_adicionada += quantidade_produto;

								System.out.println("Produto adicionado ao kit com sucesso");
							} else {
								System.out.println("A quantidade desejada excede a quantidade que tem do produto");
							}
						}

						for (ProdutoNaoDuravel produto2 : loja_logada.getList_produtos_nao_duraveis()) {
							if (produto2.getNome().contentEquals(nome)) {
								if (produto2.getQuantidade() >= (quantidade_produto * quantidade)) {
									kit.setQuantidade(kit.getQuantidade() + quantidade);
									kit.getPacote_produtos_nao_duraveis().add(produto2);
									produto2.setQuantidade(
											produto2.getQuantidade() - (quantidade_produto * quantidade));

									quantidade_adicionada += quantidade_produto;

									System.out.println("Produto adicionado ao kit com sucesso");
								} else {
									System.out.println("A quantidade desejada excede a quantidade que tem do produto");
								}
							}
						}
					}
				} else {
					System.out.println("Produto não encontrado");
					System.out.println("");
				}
			}
		}
		if (quantidade_adicionada > 1) {

			int valor_produto = verificarValorProdutosKit(kit, quantidade);
			System.out.println("O valor total dos produtos no kit é de " + valor_produto);
			System.out.println("Defina o valor do seu kit: ");
			valor = scanner.nextInt();

			if (valor > 0) {
				kit.setValor(valor);

				UsuarioDAOProxy.getLoja_acessada().getList_kits().add(kit);
				System.out.println("kit criado com sucesso");
			} else {
				System.out.println("valor invalido, kit não criado");
			}

		} else {
			System.out.println("Não foi possível criar o kit");
		}
		System.out.println("");
	}

	private int verificarValorProdutosKit(KitProduto kit, int quantidade) {
		int valor = 0;

		for (ProdutoDuravel produto : kit.getPacote_produtos_duraveis()) {
			quantidade = produto.getQuantidade() * quantidade;
			valor += produto.getValor() * quantidade;
		}

		for (ProdutoNaoDuravel produto : kit.getPacote_produtos_nao_duraveis()) {
			quantidade = produto.getQuantidade() * quantidade;
			valor += produto.getValor() * quantidade;
		}

		return valor;
	}

	private boolean verificaProduto(String nome) {

		boolean encontrou = false;
		PessoaJuridica loja = UsuarioDAOProxy.getLoja_acessada();

		for (int i = 0; i < loja.getList_produtos_duraveis().size(); i++) {
			if (loja.getList_produtos_duraveis().get(i).getNome().contentEquals(nome)) {
				System.out.println("Quantidade: " + loja.getList_produtos_duraveis().get(i).getQuantidade());
				System.out.println("");

				if (encontrou == false)
					encontrou = true;
			}

			for (int j = 0; j < loja.getList_produtos_nao_duraveis().size(); j++) {
				if (loja.getList_produtos_nao_duraveis().get(j).getNome().contentEquals(nome)) {
					System.out.println("Quantidade: " + loja.getList_produtos_nao_duraveis().get(j).getQuantidade());
					System.out.println("");

					if (encontrou == false)
						encontrou = true;
				}
			}
		}
		return encontrou;
	}

	public void mostrarKitsLoja() {

		PessoaJuridica loja_logada = (PessoaJuridica) UsuarioLogado.getUsuario_logado();

		if (loja_logada.getList_kits().size() > 0) {
			for (KitProduto kit : loja_logada.getList_kits())
				kit.toString();
		} else {
			System.out.println("Sua loja não contém nenhum kit");
		}

		new MenuPrincipalLoja().menuGeralLoja();
	}
}
