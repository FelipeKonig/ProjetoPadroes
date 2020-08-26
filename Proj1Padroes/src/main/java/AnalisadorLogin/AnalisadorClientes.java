package AnalisadorLogin;

import Usuario.PessoaFisica;
import UsuarioDAO.UsuarioDAOProxy;

public class AnalisadorClientes extends AnalisadorLogin {

	public AnalisadorClientes(AnalisadorLogin analisador) {
		super(analisador);
	}

	@Override
	protected PessoaFisica usuarioLogado(String nome_usuario, String senha) {
		PessoaFisica usuario = new UsuarioDAOProxy().buscarCliente(nome_usuario, senha);
		if (usuario != null) 
			tipo_usuario = "cliente";
		return usuario;
	}
}
