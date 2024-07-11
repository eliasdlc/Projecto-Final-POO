package Logica;

public class MicroProcesador extends Componente {
	private float velocidad;
	private String tipoConexion;
	private String plataforma;
	private int cantNucleo;
	private float energia;

	public MicroProcesador(String id, String marca, String modelo, float precio, int cantDisponible, int cantVendidos,
			float velocidad, String tipoConexion, String plataforma, int cantNucleo, float energia) {
		super(id, marca, modelo, precio, cantDisponible, cantVendidos);
		this.velocidad = velocidad;
		this.tipoConexion = tipoConexion;
		this.plataforma = plataforma;
		this.cantNucleo = cantNucleo;
		this.energia = energia;
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

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getCantNucleo() {
		return cantNucleo;
	}

	public void setCantNucleo(int cantNucleo) {
		this.cantNucleo = cantNucleo;
	}

	public float getEnergia() {
		return energia;
	}

	public void setEnergia(float energia) {
		this.energia = energia;
	}

	
	
}
