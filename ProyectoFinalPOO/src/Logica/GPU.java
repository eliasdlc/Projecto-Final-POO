package Logica;

public class GPU extends Componente {
	private String tipo;
	private float RAM;
	private float velocidad;
	private String tipoConexion;
	
	public GPU(String id, String marca, String modelo, float precio, int cantidadDisp, String tipo, float RAM, float velocidad, String tipoconexion) {
		super(id, marca, modelo, precio, cantidadDisp);
		this.tipo = tipo;
		this.RAM = RAM;
		this.velocidad = velocidad;
		this.tipoConexion = tipoconexion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getRAM() {
		return RAM;
	}

	public void setRAM(float rAM) {
		RAM = rAM;
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

}
