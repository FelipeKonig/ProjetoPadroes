package ValorCompra;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public interface InterfaceValorCompra {

	public double calcularPrecoFinal(double valor_compra, String tipo_entrega, PessoaFisica cliente, PessoaJuridica loja);

}
