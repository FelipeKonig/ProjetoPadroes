package UsuarioDAO;

public interface Observable {
	
	public void ComecarSeguirLoja(Observer observer);

	public void DeixarSeguirLoja(Observer observer);

}
