package Compra;

import java.util.ArrayList;
import java.util.List;

public class ExecutorCompra {
	
	private List<InterfaceComandoCompra> historico;
	
	public ExecutorCompra() {		
		if (this.historico == null)
			historico = new ArrayList<InterfaceComandoCompra>();
	}

	public void realizarCompra(InterfaceComandoCompra compra) {
		compra.compra();
		
		historico.add(compra);
	}
}
