package Usuario;

public class UsuarioLogado extends Pessoa {

	private String info1, info2;

	private static Object usuario_logado;

	private UsuarioLogado(String nome, String numero, String email, String nome_usuario, String senha, String info1,
			String info2, String cep) {
		this.info1 = info1;
		this.info2 = info2;		
	}

	private static Object usuarioCliente(Object usuario) {

		PessoaFisica cliente_logado = ((PessoaFisica) usuario);

		usuario_logado = new UsuarioLogado(cliente_logado.getNome(), cliente_logado.getNumero(),
				cliente_logado.getEmail(), cliente_logado.getNome_usuario(), cliente_logado.getSenha(),
				cliente_logado.getCpf(), cliente_logado.getData_nasc(), cliente_logado.getCep());

		usuario_logado = cliente_logado;

		return usuario_logado;
	}

	private static Object usuarioLoja(Object usuario) {

		PessoaJuridica loja_logada = ((PessoaJuridica) usuario);

		usuario_logado = new UsuarioLogado(loja_logada.getNome(), loja_logada.getNumero(), loja_logada.getEmail(),
				loja_logada.getNome_usuario(), loja_logada.getSenha(), loja_logada.getCnpj(),
				loja_logada.getTipo_empresa(), loja_logada.getCep());

		usuario_logado = loja_logada;

		return usuario_logado;
	}

	public static Object logarUsuario(Object usuario, String tipo_usuario) {

		if (tipo_usuario.contentEquals("cliente")) {
			usuarioCliente(usuario);
			
		} else {
			usuarioLoja(usuario);
		}
		return usuario_logado;
	}

	public static Object getUsuario_logado() {
		return usuario_logado;
	}

	public String getInfo1() {
		return info1;
	}

	public String getInfo2() {
		return info2;
	}
}
