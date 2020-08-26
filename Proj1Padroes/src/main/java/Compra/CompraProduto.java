package Compra;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public class CompraProduto extends Compra {

	public CompraProduto(PessoaFisica cliente, PessoaJuridica loja, String forma_compra, double valor,
			String tipo_entrega) {
		super(cliente, loja, forma_compra, valor, tipo_entrega);
	}

	@Override
	public boolean compra(boolean pagar_compra_cartao) {

		if (super.compra(pagar_compra_cartao) == true) {

			return true;
		}

		return false;
	}

}
