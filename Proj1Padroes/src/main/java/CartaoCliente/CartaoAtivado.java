package CartaoCliente;

public class CartaoAtivado extends EstadoCartaoCliente {

	public boolean verificaCartao(Cartao cartao_cliente) {

		if (cartao_cliente.getValor() <= 0) {

			System.out.println("O cartão está bloqueado porque seu saldo é de " + cartao_cliente.getValor() + " reais");

			cartao_cliente.setStatus(new CartaoDesativado());
			
			return false;
		}

		System.out.println("O cartão está liberado com o saldo de " + cartao_cliente.getValor() + " reais");
		
		return true;

	}

	@Override
	public String toString() {
		return "Liberado";
	}
	
	

}
