package Logica;

import java.util.ArrayList;

public class Cliente {
	private String id;
	private String nombre;
	private String correo;
	private String desc;
	private ArrayList<Componente> carrito;
	private ArrayList<Factura> misFacturas;
	
	public Cliente(String id, String nombre, String correo, String desc, ArrayList<Componente> carrito, ArrayList<Factura> misFacturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.desc = desc;
		this.carrito = carrito;
		this.misFacturas = misFacturas;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getId() {
		return id;
	}

	public ArrayList<Componente> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Componente> carrito) {
		this.carrito = carrito;
	}
	
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public void addToCarrito(Componente componente) {
		carrito.add(componente);
	}
	
}
