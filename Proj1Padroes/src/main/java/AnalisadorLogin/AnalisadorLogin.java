package AnalisadorLogin;

import Usuario.Pessoa;

public abstract class AnalisadorLogin {

	private AnalisadorLogin analisador;
	protected static String tipo_usuario;
	protected abstract Pessoa usuarioLogado(String nome, String senha);

	public AnalisadorLogin(AnalisadorLogin analisador) {
		super();
		this.analisador = analisador;
	}
	
	public Object encontrarUsuario(String nome_usuario, String senha) {
		Pessoa tipo_usuario = usuarioLogado(nome_usuario, senha);
		
		if (tipo_usuario != null) {
			return tipo_usuario;
		}else {
			return analisarProximo(nome_usuario, senha);
		}
	}
	
	private Object analisarProximo(String nome_usuario, String senha) {
		return analisador.encontrarUsuario(nome_usuario, senha);
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}
}
