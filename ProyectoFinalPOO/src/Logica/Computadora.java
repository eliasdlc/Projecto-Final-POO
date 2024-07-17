package Logica;

import java.util.ArrayList;

public class Computadora {
	private String id;
	private ArrayList<Componente> componentes;
	private float precio;
	private String tipo;
	
	public Computadora(String id, ArrayList<Componente> componentes, float precio, String tipo) {
		super();
		this.id = id;
		this.componentes = componentes;
		this.precio = precio;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
