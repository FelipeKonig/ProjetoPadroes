package UsuarioDAO;

import java.util.ArrayList;
import java.util.Scanner;

import Usuario.PessoaJuridica;

public class LojaDAO extends UsuarioDAOProxy {

	String nome, numero, email, cpf, data_nasc, cnpj, tipo_empresa, nome_usuario, senha, cep;

	Scanner scanner = new Scanner(System.in);

	@Override
	public PessoaJuridica acessarLoja(String nome_loja) {
		ArrayList<PessoaJuridica> lojas = UsuarioDAOProxy.getLojas();

		for (PessoaJuridica loja : lojas) {
			if (loja.getNome().contentEquals(nome_loja)) {
				System.out.println(loja.getNome() + "  encontrada");

				return loja;
			}
		}

		System.out.println("Loja não encontrada");
		System.out.println("");
		return null;

	}

	public PessoaJuridica cadastroLoja() {

		System.out.println("Digite a razão social da sua loja: ");
		nome = scanner.nextLine();

		System.out.println("Digite um numero o numero de telefone da sua loja: ");
		numero = scanner.nextLine();

		System.out.println("Digite o email da sua loja: ");
		email = scanner.nextLine();

		System.out.println("Digite a categoria da sua loja: ");
		tipo_empresa = scanner.nextLine();

		System.out.println("Digite o CNPJ da sua empresa: ");
		cnpj = scanner.nextLine();
		
		System.out.println("Digite seu CEP: ");
		System.out.println("OBS: Digite seu CEP sem '.' e '-'");
		cep = scanner.nextLine();

		System.out.println("Digite seu nome de usuario: ");
		nome_usuario = scanner.nextLine();

		System.out.println("Digite sua senha: ");
		senha = scanner.nextLine();

		PessoaJuridica loja = ((PessoaJuridica) new PessoaJuridica().criarNome(nome).criarNumero(numero)
				.criarEmail(email).criarNome_usuario(nome_usuario).criarSenha(senha).criarCep(cep))
				.criarCnpj(cnpj).criarTipo_empresa(tipo_empresa);

		System.out.println("Cadastro realizado!");

		System.out.println("");

		return loja;
	}

}
