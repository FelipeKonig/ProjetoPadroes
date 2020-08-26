package CarrinhoDAO;

import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;

public interface InterfaceCarrinhoDAO {

	public void adicionarProdutoDuravelCarrinho(ProdutoDuravel produto, int quantidade);

	public void adicionarProdutoNaoDuravelCarrinho(ProdutoNaoDuravel produto, int quantidade);
	
	public void adicionarProdutoKit(KitProduto kit_encontrado, int quantidade);

	public void retirarProdutoCarrinho(String nome_produto, int quantidade);

	public void verProdutosCarrinho();

	public int verificaProdutoCarrinho(String nome_produto);

	public double verificaValorCarrinho();
	
	public boolean verificarProdutosCompra();
	
	public void eliminarProdutosCompra();

}
