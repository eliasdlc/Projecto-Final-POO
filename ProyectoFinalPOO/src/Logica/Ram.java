package Logica;

public class Ram extends Componente {
	private String memoria;
	private String tipoMemoria;


	public Ram(String id, String marca, String modelo, float precio, int cantidadDisp, String memoria,
			String tipoMemoria) {
		super(id, marca, modelo, precio, cantidadDisp);
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
