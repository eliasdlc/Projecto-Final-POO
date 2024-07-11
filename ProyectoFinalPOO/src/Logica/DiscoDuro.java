package Logica;

public class DiscoDuro extends Componente {
	private float almacenamiento;
	private float velLectura;
	private float velEscritura;
	private String tipo;
	private String tipoConexion;
	
	

	public DiscoDuro(String id, String marca, String modelo, float precio, int cantDisponible, int cantVendidos,
			float almacenamiento, float velLectura, float velEscritura, String tipo, String tipoConexion) {
		super(id, marca, modelo, precio, cantDisponible, cantVendidos);
		this.almacenamiento = almacenamiento;
		this.velLectura = velLectura;
		this.velEscritura = velEscritura;
		this.tipo = tipo;
		this.tipoConexion = tipoConexion;
	}

	public float getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(float almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public float getVelLectura() {
		return velLectura;
	}

	public void setVelLectura(float velLectura) {
		this.velLectura = velLectura;
	}

	public float getVelEscritura() {
		return velEscritura;
	}

	public void setVelEscritura(float velEscritura) {
		this.velEscritura = velEscritura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	
}
