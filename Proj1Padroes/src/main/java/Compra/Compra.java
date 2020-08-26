package Compra;

import HistoricoCompraDAO.HistoricoCompraDAO;
import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;
import ValorCompra.CalcularValorCompra;

public abstract class Compra {

	protected PessoaFisica cliente;
	protected PessoaJuridica loja;
	protected String forma_compra;
	protected double valor;
	protected String tipo_entrega;

	public Compra(PessoaFisica cliente, PessoaJuridica loja, String forma_compra, double valor, String tipo_entrega) {
		this.cliente = cliente;
		this.loja = loja;
		this.valor = valor;
		this.tipo_entrega = tipo_entrega;
		this.forma_compra = forma_compra;
	}

	public boolean compra(boolean pagar_compra_cartao) {

		double valor_compra = 0;

		if (forma_compra.contentEquals("com cartao")) {
			CalcularValorCompra valor_total = new CalcularValorCompra(0);
			valor_compra = valor_total.calcularValorComCartao(tipo_entrega, valor, cliente, loja);
		} else {
			CalcularValorCompra valor_total = new CalcularValorCompra(1);
			valor_compra = valor_total.calcularValorSemCartao(tipo_entrega, valor, cliente, loja);
		}

		this.setValor(valor_compra);

		if (pagar_compra_cartao == true) {

			cliente.getCartao().setValor(cliente.getCartao().getValor() - valor_compra);

			System.out.println("Compra realizada com sucesso");

			cliente.getCartao().getStatus().verificaCartao(cliente.getCartao());

			return true;

		} else {

			if (cliente.getSaldo() >= valor_compra) {
				cliente.setSaldo(cliente.getSaldo() - valor_compra);

				System.out.println("Compra realizada com sucesso");
				System.out.println("Seu saldo atual é de " + cliente.getSaldo());

				return true;

			} else {
				System.out.println("Não foi possível realizar a compra, seu saldo atual não é o suficiente");
			}

		}

		return false;
	}

	public void enviarHistoricoCompraLoja(HistoricoCompraDAO historico) {
		historico.enviarHistoricoLoja(this);
	}

	public PessoaFisica getCliente() {
		return cliente;
	}

	public PessoaJuridica getLoja() {
		return loja;
	}

	public String getForma_compra() {
		return forma_compra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo_entrega() {
		return tipo_entrega;
	}

}
