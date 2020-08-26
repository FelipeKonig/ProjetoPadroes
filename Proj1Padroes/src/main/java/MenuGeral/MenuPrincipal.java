package MenuGeral;

import java.util.Scanner;

import AnalisadorLogin.AnalisadorClientes;
import AnalisadorLogin.AnalisadorError;
import AnalisadorLogin.AnalisadorLogin;
import AnalisadorLogin.AnalisadorLojas;
import MenuCliente.MenuPrincipalCliente;
import MenuLoja.MenuPrincipalLoja;
import UsuarioDAO.UsuarioDAOProxy;

public class MenuPrincipal {

	private int opcao = 0;

	Scanner scanner = new Scanner(System.in);

	public void menuPrincipal() {

		System.out.println("1- Logar em sua conta");
		System.out.println("2- Fazer cadastro");
		System.out.println("0- Sair");
		System.out.println("Selecione sua opção:");

		opcao = scanner.nextInt();

		if (opcao != 1 && opcao != 2 && opcao != 0) {

			while (true) {
				System.out.println("Selecione uma opção valida");
				opcao = scanner.nextInt();

				if (opcao == 1 || opcao == 2 || opcao == 0) {
					break;
				}

			}
		}

		if (opcao == 1)
			new MenuPrincipal().menuLogin();

		if (opcao == 2)
			new UsuarioDAOProxy().adicionarUsuario();

		if (opcao == 0) {
			scanner.close();
		}

	}

	public void menuLogin() {

		String nome_usuario, senha;

		System.out.println("Nome de usuario:");
		nome_usuario = scanner.nextLine();

		System.out.println("Senha:");
		senha = scanner.nextLine();
		
		try {
			AnalisadorLogin analisadorLogin = new AnalisadorClientes(new AnalisadorLojas(new AnalisadorError(null)));
			analisadorLogin.encontrarUsuario(nome_usuario, senha);
			if (analisadorLogin.getTipo_usuario().contentEquals("cliente")) {
				new MenuPrincipalCliente().menuGeralCliente();
			} else {
				new MenuPrincipalLoja().menuGeralLoja();
			}
		} catch (Exception e) {
			new MenuPrincipal().menuPrincipal();
		}
	}

}
