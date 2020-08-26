package Usuario;

import HistoricoCompra.HistoricoCompra;

public abstract class Pessoa {

	protected String nome, numero, email, nome_usuario, senha, cep;
	protected HistoricoCompra historico_compra;

	public Pessoa criarNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Pessoa criarNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public Pessoa criarEmail(String email) {
		this.email = email;
		return this;
	}

	public Pessoa criarNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
		return this;
	}

	public Pessoa criarSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public Pessoa criarCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public HistoricoCompra getHistorico_compra() {
		return historico_compra;
	}

	public void setHistorico_compra(HistoricoCompra historico_compra) {
		this.historico_compra = historico_compra;
	}

	public String toString() {
		return nome;
	}

}
