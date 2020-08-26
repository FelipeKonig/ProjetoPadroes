package ProdutoDAO;

import java.util.ArrayList;

import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;
import Usuario.PessoaJuridica;

public interface InterfaceProdutoDAO {
	
	public void adicionarProduto();
	
	public void mostrarProdutosLoja();
	
	public void mostrarProdutosLojaCliente(PessoaJuridica loja);
	
	public void BuscarProduto(String nome_produto);
	
	public void enviarProdutoCarrinho(String nome_produto, int quantidade);
	
	public int verificaProdutoLoja(String nome_produto);
	
	public void retirarProdutoLoja(String nome_produto, int quantidade);
	
	public void retirarProdutoPedidoLoja(ArrayList<ProdutoDuravel> produtos_duraveis, ArrayList<ProdutoNaoDuravel> produtos_nao_duraveis, ArrayList<KitProduto> kits);
	
	public double valor_pedido_loja(String nome_produto, int quantidade);
	
	public void adicionarKit();
	
	public void mostrarKitsLoja();
}
