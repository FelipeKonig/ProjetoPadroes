package Usuario;

import java.util.ArrayList;

import Carrinho.Carrinho;
import CartaoCliente.Cartao;
import UsuarioDAO.Observer;

public class PessoaFisica extends Pessoa {

	private String cpf, data_nasc;
	private double saldo = 120;
	private Cartao cartao;
	private boolean versao_premium = false;
	private Carrinho carrinho;
	private ArrayList<Observer> lista_lojas_seguindo = new ArrayList<Observer>();
	
	public PessoaFisica criarCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public PessoaFisica criarData_nasc(String data_nascimento) {
		this.data_nasc = data_nascimento;
		return this;
	}

	public ArrayList<Observer> getLista_lojas_seguindo() {
		return lista_lojas_seguindo;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double d) {
		this.saldo = d;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public boolean isVersao_premium() {
		return versao_premium;
	}

	public void setVersao_premium(boolean versao_premium) {
		this.versao_premium = versao_premium;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public void setLista_lojas_seguindo(ArrayList<Observer> lista_lojas_seguindo) {
		this.lista_lojas_seguindo = lista_lojas_seguindo;
	}

}
