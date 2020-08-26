package UsuarioDAO;

import java.util.Scanner;

import MenuCliente.MenuClienteLoja;
import Usuario.PessoaFisica;
import Usuario.UsuarioLogado;

public class ClienteDAO implements Observable {
	
	PessoaFisica cliente = (PessoaFisica) UsuarioLogado.getUsuario_logado();

	String nome, numero, email, cpf, data_nasc, cnpj, cep, tipo_empresa, nome_usuario, senha;

	Scanner scanner = new Scanner(System.in);
	
	public void ComecarSeguirLoja(Observer loja) {
		
		boolean verifica_loja = true;
		
		for (Observer loja_seguindo : cliente.getLista_lojas_seguindo()) {
			if (loja_seguindo == loja) {
				verifica_loja = false;
			}
		}
		
		if (verifica_loja == true) {
			cliente.getLista_lojas_seguindo().add(loja);
			
			notificarLoja(true, loja);
		}else {
			System.out.println("Você já está seguindo essa loja");
		}

		
		new MenuClienteLoja().menuGeralClienteLoja();
	}

	public void DeixarSeguirLoja(Observer loja) {
		
		boolean verifica_loja = false;
		
		for (Observer loja_seguindo : cliente.getLista_lojas_seguindo()) {
			if (loja_seguindo == loja) {
				verifica_loja = true;
			}
		}
		
		if (verifica_loja == true) {
			cliente.getLista_lojas_seguindo().remove(loja);
			
			notificarLoja(false, loja);
		}else {
			System.out.println("Você não está seguindo essa loja");
		}

		
		new MenuClienteLoja().menuGeralClienteLoja();
	}
	
	private void notificarLoja(boolean seguir,Observer loja) {
		
		if (seguir == true) {
				loja.notificaLojaClienteSeguir(this, "O cliente" + cliente.getNome() + " começou a seguir a sua loja" );
		}else {
				loja.notificaLojaClienteNaoSeguir(this, "O cliente" + cliente.getNome() + " deixou de seguir a sua loja" );
		}
		
	}

	public PessoaFisica cadastroCliente() {

		System.out.println("Digite seu nome: ");
		nome = scanner.nextLine();
	

		System.out.println("Digite seu numero de telefone: ");
		numero = scanner.nextLine();

		System.out.println("Digite seu email: ");
		email = scanner.nextLine();

		System.out.println("Digite sua data de nascimento: ");
		data_nasc = scanner.nextLine();

		System.out.println("Digite seu CPF: ");
		cpf = scanner.nextLine();
		
		System.out.println("Digite seu CEP: ");
		System.out.println("OBS: Digite seu CEP sem '.' e '-'");
		cep = scanner.nextLine();

		System.out.println("Digite seu nome de usuario: ");
		nome_usuario = scanner.nextLine();

		System.out.println("Digite sua senha: ");
		senha = scanner.nextLine();
		
		PessoaFisica cliente = ((PessoaFisica) new PessoaFisica().criarNome(nome).criarNumero(numero)
				.criarEmail(email).criarNome_usuario(nome_usuario).criarSenha(senha).criarCep(cep))
				.criarCpf(cpf).criarData_nasc(data_nasc);

		System.out.println("Cadastro realizado!");

		System.out.println("");

		return cliente;

	}


}
