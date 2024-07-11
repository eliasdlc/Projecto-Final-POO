package Logica;

public class GPU extends Componente {
	private String tipo;
	private float VRAM;
	private float velocidad;
	private String tipoConexion;
	
	public GPU(String id, String marca, String modelo, float precio, int cantidadDisp, String tipo, float VRAM, float velocidad, String tipoconexion) {
		super(id, marca, modelo, precio, cantidadDisp);
		this.tipo = tipo;
		this.VRAM = VRAM;
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
		return VRAM;
	}

	public void setRAM(float VRAM) {
		this.VRAM = VRAM;
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
