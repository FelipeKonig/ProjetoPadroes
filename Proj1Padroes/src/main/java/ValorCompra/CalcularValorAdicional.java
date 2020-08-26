package ValorCompra;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public abstract class CalcularValorAdicional {
	
	protected double verificarDistanciaEntrega(PessoaFisica cliente, PessoaJuridica loja) {
		
		int cep_cliente = Integer.parseInt(cliente.getCep());
		int cep_loja = Integer.parseInt(loja.getCep());
		
		int calculo_distancia = cep_loja - cep_cliente;
		double calculo_frete = 0;
		
		if (calculo_distancia < 0) {
			calculo_distancia = calculo_distancia * -1;
		}
		
		if (calculo_distancia <= 20000) {
			calculo_frete = 20;
		}
		else if (calculo_distancia <= 30000) {
			calculo_frete = 30;
		}
		else if (calculo_distancia <= 10000) {
			calculo_frete = 10;
		}
		else {
			calculo_frete = 40;
		}
		
		return calculo_frete;
	}
	
	protected int verificarTipoEntrega(String tipo_entrega) {
		
		int valor_entrega = 0;
		
		if (tipo_entrega == "PAC") {
			valor_entrega = 5;
		}
		
		if (tipo_entrega == "Sedex") {
			valor_entrega = 8;
		}
		
		return valor_entrega;
	}
	
	protected double verificarDescontoCompra(double valor_compra, PessoaFisica cliente) {
		return 0;
	}
	
	protected double DescontoCompraCartaoPremium(double valor_compra, PessoaFisica cliente) {

		double desconto_compra = 0;
		
		if (valor_compra > 30) {
			desconto_compra = valor_compra * 0.4;
		}

		if (valor_compra <= 30) {
			desconto_compra = valor_compra * 0.3;
		}

		if (valor_compra <= 20) {
			desconto_compra = valor_compra * 0.2;
		}

		if (valor_compra <= 10) {
			desconto_compra = valor_compra * 0.1;
		}
		
		return desconto_compra;
	}

	protected double DescontoComumCompra(double valor_compra, PessoaFisica cliente) {

		double desconto_compra = 0;
		
		if (valor_compra > 30) {
			desconto_compra = valor_compra * 0.3;
		}

		if (valor_compra <= 30) {
			desconto_compra =valor_compra - valor_compra * 0.2;
		}

		if (valor_compra <= 20) {
			desconto_compra = valor_compra * 0.1;
		}

		if (valor_compra <= 10) {
			desconto_compra = valor_compra * 0.05;
		}
		
		return desconto_compra;
	}

}
