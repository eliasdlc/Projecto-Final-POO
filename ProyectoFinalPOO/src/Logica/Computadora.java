package Logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Computadora implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private ArrayList<Componente> componentes;
	private float precio;
	private int cantDisponible;
	private String tipo;
	
	public Computadora(String id, ArrayList<Componente> componentes, float precio, int cantDisponible, String tipo) {
		super();
		this.id = id;
		this.componentes = componentes;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
		this.tipo = tipo;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
