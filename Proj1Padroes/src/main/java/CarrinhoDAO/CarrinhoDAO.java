package CarrinhoDAO;

import java.util.ArrayList;

import Carrinho.NullCarrinho;
import Carrinho.RealCarrinho;
import MenuCliente.MenuClienteLoja;
import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;
import ProdutoDAO.ProdutoDAO;
import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;
import Usuario.UsuarioLogado;

public class CarrinhoDAO implements InterfaceCarrinhoDAO {

	PessoaFisica usuario = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	private ArrayList<ProdutoDuravel> produtos_duraveis_remocao_loja = new ArrayList<ProdutoDuravel>();
	private ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis_remocao_loja = new ArrayList<ProdutoNaoDuravel>();
	private ArrayList<KitProduto> kits_remocao_loja = new ArrayList<KitProduto>();

	public void adicionarProdutoDuravelCarrinho(ProdutoDuravel produto, int quantidade) {

		ProdutoDuravel produto_escolhido = new ProdutoDuravel(produto.getNome(), produto.getCategoria(),
				produto.getData_criacao(), produto.getDescricao(), 1, produto.getValor(), produto.getTempo_garantia());

		for (int quantidade_produto = 0; quantidade_produto < quantidade; quantidade_produto++) {

			usuario.getCarrinho().getProdutos_duraveis().add(produto_escolhido);
		}

		System.out.println("O produto foi adicionado ao seu carrinho com sucesso");
		System.out.println("");

	}

	public void adicionarProdutoNaoDuravelCarrinho(ProdutoNaoDuravel produto, int quantidade) {

		ProdutoNaoDuravel produto_escolhido = new ProdutoNaoDuravel(produto.getNome(), produto.getCategoria(),
				produto.getData_criacao(), produto.getDescricao(), 1, produto.getValor(), produto.getData_validade());

		for (int quantidade_produto = 0; quantidade_produto < quantidade; quantidade_produto++) {
			usuario.getCarrinho().getProdutos_nao_duraveis().add(produto_escolhido);
		}

		System.out.println("O produto foi adicionado ao seu carrinho com sucesso");
		System.out.println("");

	}

	public void retirarProdutoCarrinho(String nome_produto, int quantidade) {

			boolean verifica_remocao = false;

			for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

				for (int indice_produto_total = 0; indice_produto_total < usuario.getCarrinho().getProdutos_duraveis()
						.size(); indice_produto_total++) {
					ProdutoDuravel produto = usuario.getCarrinho().getProdutos_duraveis().get(indice_produto_total);

					for (int indice_produto = 0; indice_produto < usuario.getCarrinho().getProdutos_duraveis()
							.size(); indice_produto++) {

						if (produto.getNome().contentEquals(nome_produto) && quantidade > 0) {
							usuario.getCarrinho().getProdutos_duraveis().remove(produto);

							quantidade = quantidade - 1;

							verifica_remocao = true;
						}

					}
				}
			}

			if (verifica_remocao == false) {

				for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

					for (int indice_produto_total = 0; indice_produto_total < usuario.getCarrinho()
							.getProdutos_nao_duraveis().size(); indice_produto_total++) {
						ProdutoNaoDuravel produto = usuario.getCarrinho().getProdutos_nao_duraveis()
								.get(indice_produto_total);

						for (int indice_produto = 0; indice_produto < usuario.getCarrinho().getProdutos_nao_duraveis()
								.size(); indice_produto++) {

							if (produto.getNome().contentEquals(nome_produto) && quantidade > 0) {
								usuario.getCarrinho().getProdutos_nao_duraveis().remove(produto);

								quantidade = quantidade - 1;

								verifica_remocao = true;
							}

						}
					}
				}
				
				if (verifica_remocao == false) {

					for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

						for (int indice_produto_total = 0; indice_produto_total < usuario.getCarrinho()
								.getKits().size(); indice_produto_total++) {
							KitProduto produto = usuario.getCarrinho().getKits()
									.get(indice_produto_total);

							for (int indice_produto = 0; indice_produto < usuario.getCarrinho().getKits()
									.size(); indice_produto++) {

								if (produto.getNome().contentEquals(nome_produto) && quantidade > 0) {
									usuario.getCarrinho().getKits().remove(produto);

									quantidade = quantidade - 1;

									verifica_remocao = true;
								}

							}
						}
					}
				}
			}

			if (verifica_remocao == true) {
				System.out.println("Produto removido com sucesso");
			} else {
				System.out.println("Produto não encontrado");
			}
	}

	public boolean verificarProdutosCompra() {

		boolean verifica_lista_produtos_duraveis = false;
		boolean verifica_lista_produtos_nao_duraveis = false;
		boolean verifica_lista_kits = false;

		PessoaJuridica loja = MenuClienteLoja.getLoja();

		ArrayList<ProdutoDuravel> produtos_duraveis_loja = new ArrayList<ProdutoDuravel>();
		ArrayList<ProdutoDuravel> produtos_duraveis_cliente = new ArrayList<ProdutoDuravel>();

		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis_loja = new ArrayList<ProdutoNaoDuravel>();
		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis_cliente = new ArrayList<ProdutoNaoDuravel>();
		
		ArrayList<KitProduto> kits_loja = new ArrayList<KitProduto>(loja.getList_kits());
		ArrayList<KitProduto> kits_cliente = new ArrayList<KitProduto>(usuario.getCarrinho().getKits());

		if (usuario.getCarrinho().getProdutos_duraveis() != null) {

			for (ProdutoDuravel produtoDuravel : usuario.getCarrinho().getProdutos_duraveis()) {
				ProdutoDuravel produto = produtoDuravel;

				ProdutoDuravel produto_reserva = new ProdutoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 1, produto.getValor(),
						produto.getTempo_garantia());

				produtos_duraveis_cliente.add(produto_reserva);
			}

			for (ProdutoDuravel produtoDuravel : loja.getList_produtos_duraveis()) {
				ProdutoDuravel produto = produtoDuravel;

				ProdutoDuravel produto_reserva = new ProdutoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 0, produto.getValor(),
						produto.getTempo_garantia());

				produtos_duraveis_loja.add(produto_reserva);
			}

			for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

				for (int i = 0; i < produtos_duraveis_cliente.size(); i++) {
					ProdutoDuravel produto = produtos_duraveis_cliente.get(i);

					for (int j = 0; j < produtos_duraveis_loja.size(); j++) {
						ProdutoDuravel produto_loja = produtos_duraveis_loja.get(j);

						for (int indice_produto = 0; indice_produto < produtos_duraveis_cliente
								.size(); indice_produto++) {

							if (produto.getNome().contentEquals(produto_loja.getNome())) {
								produtos_duraveis_cliente.remove(produto);

								produto_loja.setQuantidade(produto_loja.getQuantidade() + 1);
							}
						}
					}
				}
			}

		}

		if (produtos_duraveis_cliente.size() > 0) {
			verifica_lista_produtos_duraveis = false;
		} else {
			verifica_lista_produtos_duraveis = true;
		}

		if (usuario.getCarrinho().getProdutos_nao_duraveis() != null) {

			for (ProdutoNaoDuravel produtoDuravel : usuario.getCarrinho().getProdutos_nao_duraveis()) {
				ProdutoNaoDuravel produto = produtoDuravel;

				ProdutoNaoDuravel produto_reserva = new ProdutoNaoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 1, produto.getValor(),
						produto.getData_validade());

				produtos_nao_duraveis_cliente.add(produto_reserva);
			}

			for (ProdutoNaoDuravel produtoDuravel : loja.getList_produtos_nao_duraveis()) {
				ProdutoNaoDuravel produto = produtoDuravel;

				ProdutoNaoDuravel produto_reserva = new ProdutoNaoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 0, produto.getValor(),
						produto.getData_validade());

				produtos_nao_duraveis_loja.add(produto_reserva);
			}

			for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

				for (int i = 0; i < produtos_nao_duraveis_cliente.size(); i++) {
					ProdutoNaoDuravel produto = produtos_nao_duraveis_cliente.get(i);

					for (int j = 0; j < produtos_nao_duraveis_loja.size(); j++) {
						ProdutoNaoDuravel produto_loja = produtos_nao_duraveis_loja.get(j);

						for (int indice_produto = 0; indice_produto < produtos_nao_duraveis_cliente
								.size(); indice_produto++) {

							if (produto.getNome().contentEquals(produto_loja.getNome())) {
								produtos_nao_duraveis_cliente.remove(produto);

								produto_loja.setQuantidade(produto_loja.getQuantidade() + 1);
							}

						}
					}
				}
			}

		}

		if (produtos_nao_duraveis_cliente.size() > 0) {
			verifica_lista_produtos_nao_duraveis = false;

		} else {
			verifica_lista_produtos_nao_duraveis = true;
		}
		
		for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

			for (int i = 0; i < kits_cliente.size(); i++) {
				KitProduto kit_cliente = kits_cliente.get(i);

				for (int j = 0; j < kits_loja.size(); j++) {
					KitProduto kit_loja = kits_loja.get(j);

					for (int indice_produto = 0; indice_produto < kits_cliente
							.size(); indice_produto++) {

						if (kit_cliente.getNome().contentEquals(kit_loja.getNome())) {
							kits_cliente.remove(kit_cliente);

							kit_loja.setQuantidade(kit_loja.getQuantidade() + 1);
						}

					}
				}
			}
		}
		
		if (kits_cliente.size() > 0) {
			verifica_lista_kits = false;

		} else {
			verifica_lista_kits = true;
		}

		if (verifica_lista_produtos_nao_duraveis == true && verifica_lista_produtos_duraveis == true && verifica_lista_kits == true) {

			return true;

		} else {

			System.out.println("Esses produtos não pertencem a loja " + loja.getNome());
			for (ProdutoDuravel produtoDuravel : produtos_duraveis_cliente)
				System.out.println("Nome do produto: " + produtoDuravel.getNome());

			for (ProdutoNaoDuravel produtoNaoDuravel : produtos_nao_duraveis_cliente)
				System.out.println("Nome do produto: " + produtoNaoDuravel.getNome());
			
			for (KitProduto kitProduto : kits_cliente) {
				System.out.println(kitProduto.getNome());
			}
			
			return false;
		}

	}

	public void verProdutosCarrinho() {
		if (usuario.getCarrinho() == null)
			System.out.println(new NullCarrinho().getInformacao());

		if (usuario.getCarrinho() != null) {
			System.out.println("Produtos que estão no seu carrinho:");
			System.out.println(new RealCarrinho().getInformacao());

		}
	}

	public int verificaProdutoCarrinho(String nome_produto) {

		int quantidade = 0;

		for (ProdutoDuravel produto : usuario.getCarrinho().getProdutos_duraveis()) {
			if (produto.getNome().contains(nome_produto)) {
				quantidade++;
			}
		}

		for (ProdutoNaoDuravel produto : usuario.getCarrinho().getProdutos_nao_duraveis()) {
			if (produto.getNome().contains(nome_produto)) {
				quantidade++;
			}
		}

		for (KitProduto kit : usuario.getCarrinho().getKits()) {
			if (kit.getNome().contains(nome_produto)) {
				quantidade++;
			}
		}

		return quantidade;
	}

	public double verificaValorCarrinho() {

		double valor = 0;

		if (usuario.getCarrinho().getProdutos_duraveis() != null) {
			for (ProdutoDuravel produto : usuario.getCarrinho().getProdutos_duraveis()) {
				valor += produto.getValor();
			}
		}

		if (usuario.getCarrinho().getProdutos_nao_duraveis() != null) {
			for (ProdutoNaoDuravel produto : usuario.getCarrinho().getProdutos_nao_duraveis()) {
				valor += produto.getValor();
			}
		}
		
		if (usuario.getCarrinho().getKits() != null) {
			for (KitProduto kit : usuario.getCarrinho().getKits()) {
				valor += kit.getValor();
			}
		}

		return valor;
	}

	public void eliminarProdutosCompra() {
		boolean verifica_lista_produtos_duraveis = false;
		boolean verifica_lista_produtos_nao_duraveis = false;
		boolean verifica_lista_kits = false;

		PessoaJuridica loja = MenuClienteLoja.getLoja();

		ArrayList<ProdutoDuravel> produtos_duraveis_loja = new ArrayList<ProdutoDuravel>();
		ArrayList<ProdutoDuravel> produtos_duraveis_cliente = new ArrayList<ProdutoDuravel>();

		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis_loja = new ArrayList<ProdutoNaoDuravel>();
		ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis_cliente = new ArrayList<ProdutoNaoDuravel>();
		
		ArrayList<KitProduto> kits_cliente = new ArrayList<KitProduto>(usuario.getCarrinho().getKits());
		ArrayList<KitProduto> kits_loja = new ArrayList<KitProduto>(loja.getList_kits());

		if (usuario.getCarrinho().getProdutos_duraveis() != null) {

			for (ProdutoDuravel produtoDuravel : usuario.getCarrinho().getProdutos_duraveis()) {
				ProdutoDuravel produto = produtoDuravel;

				ProdutoDuravel produto_reserva = new ProdutoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 1, produto.getValor(),
						produto.getTempo_garantia());

				produtos_duraveis_cliente.add(produto_reserva);
			}

			for (ProdutoDuravel produtoDuravel : loja.getList_produtos_duraveis()) {
				ProdutoDuravel produto = produtoDuravel;

				ProdutoDuravel produto_reserva = new ProdutoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 0, produto.getValor(),
						produto.getTempo_garantia());

				produtos_duraveis_loja.add(produto_reserva);
			}

			for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

				for (int i = 0; i < produtos_duraveis_cliente.size(); i++) {
					ProdutoDuravel produto = produtos_duraveis_cliente.get(i);

					for (int j = 0; j < produtos_duraveis_loja.size(); j++) {
						ProdutoDuravel produto_loja = produtos_duraveis_loja.get(j);

						if (produto.getNome().contentEquals(produto_loja.getNome())) {
							produtos_duraveis_cliente.remove(produto);

							produto_loja.setQuantidade(produto_loja.getQuantidade() + 1);

						}

					}
				}
			}

		}

		if (produtos_duraveis_cliente.size() > 0) {
			verifica_lista_produtos_duraveis = false;
		} else {
			verifica_lista_produtos_duraveis = true;
		}

		if (usuario.getCarrinho().getProdutos_nao_duraveis() != null) {

			for (ProdutoNaoDuravel produtoDuravel : usuario.getCarrinho().getProdutos_nao_duraveis()) {
				ProdutoNaoDuravel produto = produtoDuravel;

				ProdutoNaoDuravel produto_reserva = new ProdutoNaoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 1, produto.getValor(),
						produto.getData_validade());

				produtos_nao_duraveis_cliente.add(produto_reserva);
			}

			for (ProdutoNaoDuravel produtoDuravel : loja.getList_produtos_nao_duraveis()) {
				ProdutoNaoDuravel produto = produtoDuravel;

				ProdutoNaoDuravel produto_reserva = new ProdutoNaoDuravel(produto.getNome(), produto.getCategoria(),
						produto.getData_criacao(), produto.getDescricao(), 0, produto.getValor(),
						produto.getData_validade());

				produtos_nao_duraveis_loja.add(produto_reserva);
			}

			for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

				for (int i = 0; i < produtos_nao_duraveis_cliente.size(); i++) {
					ProdutoNaoDuravel produto = produtos_nao_duraveis_cliente.get(i);

					for (int j = 0; j < produtos_nao_duraveis_loja.size(); j++) {
						ProdutoNaoDuravel produto_loja = produtos_nao_duraveis_loja.get(j);

						if (produto.getNome().contentEquals(produto_loja.getNome())) {
							produtos_nao_duraveis_cliente.remove(produto);

							produto_loja.setQuantidade(produto_loja.getQuantidade() + 1);
						}

					}
				}
			}

		}

		if (produtos_nao_duraveis_cliente.size() > 0) {
			verifica_lista_produtos_nao_duraveis = false;

		} else {
			verifica_lista_produtos_nao_duraveis = true;
		}
		
		for (int tentativa_excluir_produto = 0; tentativa_excluir_produto < 5; tentativa_excluir_produto++) {

			for (int i = 0; i < kits_cliente.size(); i++) {
				KitProduto kit = kits_cliente.get(i);

				for (int j = 0; j < kits_loja.size(); j++) {
					KitProduto kit_loja = kits_loja.get(j);

					if (kit.getNome().contentEquals(kit_loja.getNome())) {
						kits_cliente.remove(kit);

						kit_loja.setQuantidade(kit_loja.getQuantidade() + 1);
					}

				}
			}
		}

	if (kits_cliente.size() > 0) {
		verifica_lista_kits = false;

	} else {
		verifica_lista_kits = true;
	}

		if (verifica_lista_produtos_nao_duraveis == true && verifica_lista_produtos_duraveis == true && verifica_lista_kits == true) {

			usuario.getCarrinho().getProdutos_duraveis().clear();
			usuario.getCarrinho().getProdutos_nao_duraveis().clear();
			usuario.getCarrinho().getKits().clear();

			for (ProdutoNaoDuravel produto_nao_duravel : produtos_nao_duraveis_loja) {
				if (produto_nao_duravel.getQuantidade() > 0)
					produtos_nao_duraveis_remocao_loja.add(produto_nao_duravel);
			}

			for (ProdutoDuravel produto_duravel : produtos_duraveis_loja) {
				if (produto_duravel.getQuantidade() > 0)
					produtos_duraveis_remocao_loja.add(produto_duravel);
			}
			
			for (KitProduto kit : kits_loja) {
				if (kit.getQuantidade() > 0)
					kits_remocao_loja.add(kit);
			}

			new ProdutoDAO().retirarProdutoPedidoLoja(produtos_duraveis_remocao_loja,
					produtos_nao_duraveis_remocao_loja, kits_remocao_loja);

		} else {
			System.out.println("Algo errado aconteceu");
		}
	}

	public void adicionarProdutoKit(KitProduto kit_encontrado, int quantidade) {

		KitProduto kit_escolhido = new KitProduto(kit_encontrado.getNome(), kit_encontrado.getCategoria(),
				kit_encontrado.getData_criacao(), kit_encontrado.getDescricao(), 1, kit_encontrado.getValor());

		for (int quantidade_produto = 0; quantidade_produto < quantidade; quantidade_produto++) {

			usuario.getCarrinho().getKits().add(kit_escolhido);
		}

		System.out.println("O kit foi adicionado ao seu carrinho com sucesso");
		System.out.println("");

	}
}
