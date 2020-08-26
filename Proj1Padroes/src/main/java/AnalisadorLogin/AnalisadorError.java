package AnalisadorLogin;

import Usuario.Pessoa;

public class AnalisadorError extends AnalisadorLogin{

	public AnalisadorError(AnalisadorLogin analisador) {
		super(analisador);
	}

	@Override
	protected Pessoa usuarioLogado(String nome, String senha) {
		System.out.println("O usuario não foi encontrado");
		System.out.println("");
		return null;
	}
		
	
}
