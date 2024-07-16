package Logica;

public class Componente {
	private String id;
	private String marca;
	private String modelo;
	private float precio;
	private int cantDisponible;
	private int cantVendidos;
	private int descuento;


	public Componente(String id, String marca, String modelo, float precio, int cantDisponible, int cantVendidos) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
		this.cantVendidos = cantVendidos;
		this.descuento = 0;
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

	public String getId() {
		return id;
	}

	public int getCantDisponible() {
		return cantDisponible;
	}

	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}

	public int getCantVendidos() {
		return cantVendidos;
	}

	public void setCantVendidos(int cantVendidos) {
		this.cantVendidos = cantVendidos;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	
	
}
