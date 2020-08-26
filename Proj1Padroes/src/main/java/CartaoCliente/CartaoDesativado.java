package CartaoCliente;

public class CartaoDesativado extends EstadoCartaoCliente {

	public boolean verificaCartao(Cartao cartao_cliente) {

		if (cartao_cliente.getValor() > 0) {

			System.out.println("O cartão estava bloqueado e agora está liberado e com o saldo de " + cartao_cliente.getValor() + " reais");

			cartao_cliente.setStatus(new CartaoAtivado());
			
			return true;

		}

		System.out.println("O cartão está bloqueado porque seu saldo é de " + cartao_cliente.getValor() + " reais");
		
		return false;
	}

	@Override
	public String toString() {
		return "Bloqueado";
	}
	
	

}
