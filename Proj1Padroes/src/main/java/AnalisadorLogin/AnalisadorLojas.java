package AnalisadorLogin;

import Usuario.PessoaJuridica;
import UsuarioDAO.UsuarioDAOProxy;

public class AnalisadorLojas extends AnalisadorLogin{

	public AnalisadorLojas(AnalisadorLogin analisador) {
		super(analisador);
	}

	@Override
	protected PessoaJuridica usuarioLogado(String nome_usuario, String senha) {
		PessoaJuridica usuario = new UsuarioDAOProxy().buscarLoja(nome_usuario, senha);
		if (usuario != null) 
			tipo_usuario = "loja";
		return usuario;
	}
}
