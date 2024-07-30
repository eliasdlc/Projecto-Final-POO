package Logica;

public class Ram extends Componente {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memoria;
	private String tipoMemoria;

	public Ram(String id, String marca, String modelo, float precio, int cantDisponible, int cantVendidos
				, String memoria, String tipoMemoria) {
		super(id, marca, modelo, precio, cantDisponible, cantVendidos);
		this.memoria = memoria;
		this.tipoMemoria = tipoMemoria;
	}

	public String getMemoria() {
		return memoria;
	}


	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}


	public String getTipoMemoria() {
		return tipoMemoria;
	}


	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
	

}
