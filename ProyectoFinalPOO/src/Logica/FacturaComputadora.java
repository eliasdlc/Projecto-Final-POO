package Logica;

public class FacturaComputadora extends Factura {
	private static String idComputadora;
	
	public FacturaComputadora(String idCliente, String id, Float montoTotal, String idcomputadora) {
		super(idCliente, id, montoTotal);
		this.idComputadora = idcomputadora;
	}

	public static String getIdComputadora() {
		return idComputadora;
	}

	
}
