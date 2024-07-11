package Logica;

import java.util.ArrayList;

public class Computadora {
	private String id;
	private ArrayList<Componente> componentes;
	private float precio;
	
	public Computadora(String id, ArrayList<Componente> componentes, float precio) {
		super();
		this.id = id;
		this.componentes = componentes;
		this.precio = precio;
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
	
	
}
