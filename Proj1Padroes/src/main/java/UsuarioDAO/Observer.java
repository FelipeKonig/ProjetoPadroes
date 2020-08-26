package UsuarioDAO;

public interface Observer {
	
	public void notificaLojaClienteSeguir(Observable cliente, String message);
	public void notificaLojaClienteNaoSeguir(Observable cliente, String message);

}
