package Logica;

public class Componente {
	private String id;
	private String marca;
	private String modelo;
	private float precio;
	private int cantidadDisp;


	public Componente(String id, String marca, String modelo, float precio, int cantidadDisp) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidadDisp = cantidadDisp;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidadDisp() {
		return cantidadDisp;
	}
	public void setCantidadDisp(int cantidadDisp) {
		this.cantidadDisp = cantidadDisp;
	}
	public String getId() {
		return id;
	}
	
	
}
