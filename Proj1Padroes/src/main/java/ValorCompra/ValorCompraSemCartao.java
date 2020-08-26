package ValorCompra;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public class ValorCompraSemCartao extends CalcularValorAdicional implements InterfaceValorCompra {

	public double calcularPrecoFinal(double valor_compra,String tipo_entrega, PessoaFisica cliente, PessoaJuridica loja) {
		
		double calcular_desconto = verificarDescontoCompra(valor_compra, cliente);
		
		double valor_distancia = verificarDistanciaEntrega( cliente, loja);
		
		System.out.println("O valor da entrega desse trajeto é de " + valor_distancia + " reais");
		System.out.println("O valor do " + tipo_entrega + " é de " + verificarTipoEntrega(tipo_entrega) + " reais");
		
		System.out.println("O valor do(s) produto(s) é "+ valor_compra);
		
		valor_compra = (valor_compra - calcular_desconto) + (valor_distancia + verificarTipoEntrega(tipo_entrega));
		
		System.out.println("O valor do desconto é de " + calcular_desconto + " reais");
		
		System.out.println("O valor total da compra é " + valor_compra + " reais");
		
		return valor_compra;
	}
	
	@Override
	protected  double verificarDescontoCompra(double valor_compra, PessoaFisica cliente) {
		double desconto_compra = 0;

		if (cliente.isVersao_premium() == true) 
			desconto_compra = DescontoComumCompra(valor_compra, cliente);

		return desconto_compra;
	}
	
	@Override
	protected  double verificarDistanciaEntrega(PessoaFisica cliente, PessoaJuridica loja) {
		return super.verificarDistanciaEntrega(cliente, loja);
	}
	
	@Override
	protected int verificarTipoEntrega(String tipo_entrega) {
		return super.verificarTipoEntrega(tipo_entrega);
	}
	
	@Override
	public String toString() {
		return "Compra sem cartão especial";
	}


}
