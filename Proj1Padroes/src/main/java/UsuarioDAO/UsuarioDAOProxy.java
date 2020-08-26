package UsuarioDAO;

import java.util.ArrayList;
import java.util.Scanner;

import MenuCliente.MenuPrincipalCliente;
import MenuGeral.MenuPrincipal;
import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;
import Usuario.UsuarioLogado;

public class UsuarioDAOProxy implements InterfaceUsuarioDAO  {

	private static ArrayList<PessoaFisica> clientes = new ArrayList<PessoaFisica>();
	private static ArrayList<PessoaJuridica> lojas = new ArrayList<PessoaJuridica>();
	
	private static PessoaJuridica loja_acessada;
	
	Scanner scanner = new Scanner(System.in);

	public int adicionarUsuario() {

		String tipo_usuario = null;

		System.out.println("Digite 1 para se cadastrar como cliente");
		System.out.println("Digite 2 para cadastrar sua loja");

		tipo_usuario = scanner.nextLine();
		
		if (tipo_usuario.contentEquals("1")) {
			PessoaFisica cliente = new ClienteDAO().cadastroCliente();
			clientes.add(cliente);
			
			new MenuPrincipal().menuPrincipal();

		}

		if (tipo_usuario.contentEquals("2")) {
			PessoaJuridica loja = new LojaDAO().cadastroLoja();
			lojas.add(loja);

			new MenuPrincipal().menuPrincipal();

		}

		return 0;

	}

	public void verLojasSeguindo() {
		
		PessoaFisica cliente_logado = (PessoaFisica) UsuarioLogado.getUsuario_logado();

		if (cliente_logado.getLista_lojas_seguindo().size() > 0) {
			System.out.println("Lojas que você segue: ");
			for (Observer loja : cliente_logado.getLista_lojas_seguindo())
				System.out.println(loja.toString());
		} else {
			System.out.println("Você está seguindo nenhuma loja");
		}

		System.out.println("");
		new MenuPrincipalCliente().menuGeralCliente();
	}

	public PessoaFisica buscarCliente(String nome_usuario, String senha) {

		for (PessoaFisica cliente : clientes) {
			if (cliente.getNome_usuario().contentEquals(nome_usuario)) {
				if (cliente.getSenha().contentEquals(senha)) {

					UsuarioLogado.logarUsuario(cliente,"cliente");

					System.out.println("");
					System.out.println("Seja bem vindo cliente " + cliente.getNome());

					return cliente;
				}
			}
		}
		return null;
	}

	public PessoaJuridica buscarLoja(String nome_usuario, String senha) {

		for (PessoaJuridica loja : lojas) {
			if (loja.getNome_usuario().contentEquals(nome_usuario)) {
				if (loja.getSenha().contentEquals(senha)) {

					UsuarioLogado.logarUsuario(loja,"loja");
					
					System.out.println("");
					System.out.println("Seja bem vinda loja " + loja.getNome());
					
					return loja;
				}
			}
		}
		return null;
	}

	public void mostrarLojas() {
		for (PessoaJuridica loja : lojas) {
			System.out.println("Nome: " + loja.getNome());
			System.out.println("Categoria: " + loja.getTipo_empresa());

			System.out.println("");
		}

		System.out.println("");

		new MenuPrincipalCliente().menuGeralCliente();
	}

	public PessoaJuridica acessarLoja(String nome_loja) {

		System.out.println("");
		
		loja_acessada = new LojaDAO().acessarLoja(nome_loja);

		return loja_acessada;

	}

	public static ArrayList<PessoaFisica> getClientes() {
		if (clientes == null)
			clientes = new ArrayList<PessoaFisica>();
		return clientes;
	}

	public static ArrayList<PessoaJuridica> getLojas() {
		if (lojas == null)
			lojas = new ArrayList<PessoaJuridica>();
		return lojas;
	}

	public static PessoaJuridica getLoja_acessada() {
		return loja_acessada;
	}
}
