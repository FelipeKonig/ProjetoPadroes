package CartaoCliente;

import Usuario.PessoaFisica;

public class Cartao {

	private double valor;
	private EstadoCartaoCliente status;

	public Cartao(float valor, EstadoCartaoCliente status) {
		super();
		this.valor = valor;
		this.status = status;
	}

	public Cartao() {
	}

	public void ativarCartao(PessoaFisica cliente) {
		
		cliente.getCartao().setValor(50 + cliente.getCartao().getValor());
		
		if (cliente.getCartao().getStatus() == null) {
			cliente.getCartao().setStatus(new CartaoAtivado());
			status.verificaCartao(cliente.getCartao());
		}else{
			status.verificaCartao(cliente.getCartao());
		}
		
		cliente.setSaldo(cliente.getSaldo() - 30);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double d) {
		this.valor = d;
	}

	public EstadoCartaoCliente getStatus() {
		return status;
	}

	public void setStatus(EstadoCartaoCliente status) {
		this.status = status;
	}

}
