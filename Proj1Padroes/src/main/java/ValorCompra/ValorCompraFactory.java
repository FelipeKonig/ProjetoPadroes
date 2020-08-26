package ValorCompra;

import java.util.HashMap;
import java.util.Map;

public class ValorCompraFactory {
	
	private static Map<Integer, InterfaceValorCompra> valor_compra;
	
	private static void criarCompra() {
		valor_compra = new HashMap<Integer, InterfaceValorCompra>();
		
		valor_compra.put(0, new ValorCompraCartao());
		valor_compra.put(1, new ValorCompraSemCartao());
	}
	
	public static InterfaceValorCompra tipoValorCompra(Integer tipo) {
		if (valor_compra == null)
			criarCompra();
		
		return valor_compra.get(tipo);
	}

}
