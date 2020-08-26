package ValorCompra;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public class ValorCompraCartao extends CalcularValorAdicional implements InterfaceValorCompra {
		
	public double calcularPrecoFinal(double valor_compra, String tipo_entrega, PessoaFisica cliente,
			PessoaJuridica loja) {

		double calcular_desconto = verificarDescontoCompra(valor_compra, cliente);

		System.out.println("O valor do(s) produto(s) é " + valor_compra + " reais");

		valor_compra = valor_compra - calcular_desconto;

		System.out.println("O valor do desconto é de " + calcular_desconto + " reais");

		System.out.println("O valor total da compra é " + valor_compra + " reais");
		System.out.println("A entrega vai ser realizada pelo Sedex");

		return valor_compra;
	}

	@Override
	protected double verificarDescontoCompra(double valor_compra, PessoaFisica cliente) {

		double desconto_compra = 0;

		if (cliente.isVersao_premium() == true) {
			desconto_compra = DescontoCompraCartaoPremium(valor_compra, cliente);
		} else {
			desconto_compra = DescontoComumCompra(valor_compra, cliente);
		}

		return desconto_compra;
	}

	@Override
	public String toString() {
		return "Compra por cartão especial";
	}

}
