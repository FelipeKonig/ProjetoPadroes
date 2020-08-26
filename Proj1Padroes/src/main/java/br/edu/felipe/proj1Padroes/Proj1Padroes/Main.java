package br.edu.felipe.proj1Padroes.Proj1Padroes;

import MenuGeral.MenuPrincipal;
import Produto.KitProduto;
import Produto.ProdutoDuravel;
import Produto.ProdutoNaoDuravel;
import Usuario.PessoaFisica;
import Usuario.PessoaJuridica;
import UsuarioDAO.UsuarioDAOProxy;

public class Main {
	public static void main(String[] args) {

		add();
		
		System.out.println("Bem vindo!");

		new MenuPrincipal().menuPrincipal();

	}
	
	private static void add() {
		
		PessoaFisica cliente1 = ((PessoaFisica) new PessoaFisica().criarNome("Felipe").criarNumero("123")
				.criarEmail("lipekonig@gmail.com").criarNome_usuario("admin").criarSenha("admin").criarCep("90000000"))
				.criarCpf("123").criarData_nasc("10/11/1999");
		
		PessoaFisica cliente2 = ((PessoaFisica) new PessoaFisica().criarNome("Charles").criarNumero("1234")
				.criarEmail("charles@gmail.com").criarNome_usuario("charles").criarSenha("charles").criarCep("60000000"))
				.criarCpf("1234").criarData_nasc("10/11/1999");
		
		PessoaFisica cliente3 = ((PessoaFisica) new PessoaFisica().criarNome("Pedro").criarNumero("12345")
				.criarEmail("pedro@gmail.com").criarNome_usuario("pedro").criarSenha("pedro").criarCep("10000000"))
				.criarCpf("12345").criarData_nasc("10/11/1999");
		
		PessoaFisica cliente4 = ((PessoaFisica) new PessoaFisica().criarNome("Silvio").criarNumero("123456")
				.criarEmail("silvio@gmail.com").criarNome_usuario("silvio").criarSenha("silvio").criarCep("30000000"))
				.criarCpf("123456").criarData_nasc("10/11/1999");
		
//		PessoaFisica cliente1 = new PessoaFisica("Felipe", "123", "lipekonig@gmail.com", "admin", "admin", "123",
//				"10/11/1999", "90000000");
//		PessoaFisica cliente2 = new PessoaFisica("Charles", "1234", "charles@gmail.com", "charles", "charles", "1234",
//				"10/11/1999", "60000000");
//		PessoaFisica cliente3 = new PessoaFisica("Pedro", "12345", "pedro@gmail.com", "pedro", "pedro", "12345",
//				"10/11/1999", "10000000");
//		PessoaFisica cliente4 = new PessoaFisica("Silvio", "123456", "silvio@gmail.com", "silvio", "silvio", "123456",
//				"10/11/1999", "30000000");
		
		PessoaJuridica loja1 = ((PessoaJuridica) new PessoaJuridica().criarNome("Amazon").criarNumero("111")
				.criarEmail("amazon@amazon.com").criarNome_usuario("amazon").criarSenha("amazon").criarCep("40000000"))
				.criarCnpj("111").criarTipo_empresa("Geral");
		
		PessoaJuridica loja2 = ((PessoaJuridica) new PessoaJuridica().criarNome("Americanas").criarNumero("222")
				.criarEmail("americanas@americanas.com").criarNome_usuario("americanas").criarSenha("americanas").criarCep("70000000"))
				.criarCnpj("222").criarTipo_empresa("Geral");
		
		PessoaJuridica loja3 = ((PessoaJuridica) new PessoaJuridica().criarNome("Submarino").criarNumero("333")
				.criarEmail("submarino@submarino.com").criarNome_usuario("submarino").criarSenha("submarino").criarCep("90000000"))
				.criarCnpj("333").criarTipo_empresa("Geral");
		
		PessoaJuridica loja4 = ((PessoaJuridica) new PessoaJuridica().criarNome("Olx").criarNumero("444")
				.criarEmail("olx@olx.com").criarNome_usuario("olx").criarSenha("olx").criarCep("50000000"))
				.criarCnpj("444").criarTipo_empresa("Geral");
		

//		PessoaJuridica loja1 = new PessoaJuridica("Amazon", "111", "amazon@amazon.com", "amazon", "amazon", "111",
//				"Geral", "40000000");
//		PessoaJuridica loja2 = new PessoaJuridica("Americanas", "222", "americanas@americanas.com", "americanas",
//				"americanas", "222", "Geral", "70000000");
//		PessoaJuridica loja3 = new PessoaJuridica("Submarino", "333", "submarino@submarino.com", "submarino",
//				"submarino", "333", "Geral", "90000000");
//		PessoaJuridica loja4 = new PessoaJuridica("Olx", "444", "olx@olx.com", "olx", "olx", "444", "Geral", "50000000");

		ProdutoDuravel produtoDuravel1 = new ProdutoDuravel("geladeira", "eletrodoméstico", "05/04/2020", "é grande", 5,
				50, "100 dias");
		ProdutoDuravel produtoDuravel2 = new ProdutoDuravel("carro", "automóvel", "01/02/2020", "4 portas", 7, 80,
				"200 dias");
		ProdutoDuravel produtoDuravel3 = new ProdutoDuravel("batedeira", "eletrodoméstico", "15/02/2020", "200 watts",
				6, 5, "1 dia");
		ProdutoDuravel produtoDuravel4 = new ProdutoDuravel("martelo", "material de construção", "29/01/2020",
				"De ferro", 2, 10, "7 dias");
		ProdutoDuravel produtoDuravel5 = new ProdutoDuravel("alicate", "material de construção", "29/01/2020",
				"De ferro", 3, 5, "7 dias");

		ProdutoNaoDuravel produtoNaoDuravel1 = new ProdutoNaoDuravel("melancia", "alimento", "20/09/2020", "bem madura",
				3, 1, "27/09/2020");
		ProdutoNaoDuravel produtoNaoDuravel2 = new ProdutoNaoDuravel("laranja", "alimento", "11/07/2020", "suculenta",
				9, 3, "18/07/2020");
		ProdutoNaoDuravel produtoNaoDuravel3 = new ProdutoNaoDuravel("banana", "alimento", "03/01/2020",
				"1kg", 2, 7, "12/05/2020");
		ProdutoNaoDuravel produtoNaoDuravel4 = new ProdutoNaoDuravel("amoeba", "brinquedo", "18/03/2019", "multicores",
				3, 1, "30/11/2020");
		ProdutoNaoDuravel produtoNaoDuravel5 = new ProdutoNaoDuravel("bolacha", "alimento", "18/03/2019", "sabor chocolate",
				2, 3, "30/11/2020");
		
		KitProduto kit = new KitProduto("kit1", "Geral", "12/10/2020", "Contém produtos populares", 1, 20);
		kit.getPacote_produtos_duraveis().add(produtoDuravel5);
		kit.getPacote_produtos_nao_duraveis().add(produtoNaoDuravel5);
		
		loja1.getList_produtos_duraveis().add(produtoDuravel1);
		loja1.getList_produtos_nao_duraveis().add(produtoNaoDuravel1);
		loja1.getList_kits().add(kit);
		
		loja2.getList_produtos_duraveis().add(produtoDuravel2);
		loja2.getList_produtos_nao_duraveis().add(produtoNaoDuravel2);
		
		loja3.getList_produtos_duraveis().add(produtoDuravel3);
		loja3.getList_produtos_nao_duraveis().add(produtoNaoDuravel3);

		loja4.getList_produtos_duraveis().add(produtoDuravel4);
		loja4.getList_produtos_nao_duraveis().add(produtoNaoDuravel4);		
		
		UsuarioDAOProxy.getClientes().add(cliente1);
		UsuarioDAOProxy.getClientes().add(cliente2);
		UsuarioDAOProxy.getClientes().add(cliente3);
		UsuarioDAOProxy.getClientes().add(cliente4);


		UsuarioDAOProxy.getLojas().add(loja1);
		UsuarioDAOProxy.getLojas().add(loja2);
		UsuarioDAOProxy.getLojas().add(loja3);
		UsuarioDAOProxy.getLojas().add(loja4);
		
	}
}
