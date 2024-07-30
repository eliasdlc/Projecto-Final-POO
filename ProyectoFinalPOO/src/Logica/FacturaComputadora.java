package Logica;

public class FacturaComputadora extends Factura {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantComputadoras;
	private String idComputadora;
	
	
	public FacturaComputadora(String idCliente, String id, Float montoTotal, int cantComputadoras,
			String idComputadora) {
		super(idCliente, id, montoTotal);
		this.cantComputadoras = cantComputadoras;
		this.idComputadora = idComputadora;
	}

	public int getCantComputadoras() {
		return cantComputadoras;
	}
	
	public void setCantComputadoras(int cantComputadoras) {
		this.cantComputadoras = cantComputadoras;
	}

	public String getIdComputadora() {
		return idComputadora;
	}

	public void setIdComputadora(String idComputadora) {
		this.idComputadora = idComputadora;
	}
}
