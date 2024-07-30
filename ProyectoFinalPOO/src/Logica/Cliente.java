package Logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String correo;
	private String desc;
	private String numero;
	private String direccion;
	private ArrayList<Componente> carrito;
	private ArrayList<Factura> misFacturas;
	
	public Cliente(String id, String nombre, String correo, String desc, String numero, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.desc = desc;
		this.numero = numero;
		this.direccion = direccion;
		this.carrito = new ArrayList<>();;
		this.misFacturas = new ArrayList<>();
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
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	public void addFactura(Factura factura) {
		misFacturas.add(factura);
	}
	
}
