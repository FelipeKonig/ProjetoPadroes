package UsuarioDAO;

import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;

public interface InterfaceUsuarioDAO {
	
	public int adicionarUsuario();
	
	public PessoaFisica buscarCliente(String nome_usuario, String senha);
	
	public PessoaJuridica buscarLoja(String nome_usuario, String senha);	
	
	public void mostrarLojas();
	
	public void verLojasSeguindo();
	
	public PessoaJuridica acessarLoja(String nome_loja);
}
