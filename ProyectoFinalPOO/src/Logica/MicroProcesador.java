package Logica;

public class MicroProcesador extends Componente {
	private float velocidad;
	private String tipoConexion;
	private int cantNucleo;


	public MicroProcesador(String id, String marca, String modelo, float precio, int cantDisponible, int cantVendidos,
			int cantSeleccionado, float velocidad, String tipoConexion, int cantNucleo) {
		super(id, marca, modelo, precio, cantDisponible, cantVendidos, cantSeleccionado);
		this.velocidad = velocidad;
		this.tipoConexion = tipoConexion;
		this.cantNucleo = cantNucleo;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	public int getCantNucleo() {
		return cantNucleo;
	}

	public void setCantNucleo(int cantNucleo) {
		this.cantNucleo = cantNucleo;
	}
	
}
