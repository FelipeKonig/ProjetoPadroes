package ValorCompra;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public class CalcularValorCompra {

	private ValorCompraCartao valor_cartao;
	private ValorCompraSemCartao valor_semCartao;

	public CalcularValorCompra(Integer tipo) {
		
		if (tipo == 0) {
			valor_cartao = (ValorCompraCartao) ValorCompraFactory.tipoValorCompra(tipo);
		} else {
			valor_semCartao = (ValorCompraSemCartao) ValorCompraFactory.tipoValorCompra(tipo);
		}
	}

	public double calcularValorComCartao(String tipo_entrega, double valor_compra, PessoaFisica cliente,
			PessoaJuridica loja) {
		return valor_cartao.calcularPrecoFinal(valor_compra, tipo_entrega, cliente, loja);
	}

	public double calcularValorSemCartao(String tipo_entrega, double valor_compra, PessoaFisica cliente,
			PessoaJuridica loja) {
		return valor_semCartao.calcularPrecoFinal(valor_compra, tipo_entrega, cliente, loja);
	}
}
