package Logica;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	
	private String conectionSocket;
	private ArrayList<String> tipoRam;
	private ArrayList<String> tipoDiscoDuro;
	
	public TarjetaMadre(String id, String marca, String modelo, float precio, int cantidadDisp, String conectionSocket, ArrayList<String> tipoRam, ArrayList<String> tipoDiscoDuro) {
		super(id, marca, modelo, precio, cantidadDisp);
		// TODO Auto-generated constructor stub
		this.conectionSocket = conectionSocket;
		this.tipoRam = tipoRam;
		this.tipoDiscoDuro = tipoDiscoDuro;
	}

	public String getConectionSocket() {
		return conectionSocket;
	}

	public void setConectionSocket(String conectionSocket) {
		this.conectionSocket = conectionSocket;
	}

	public ArrayList<String> getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(ArrayList<String> tipoRam) {
		this.tipoRam = tipoRam;
	}

	public ArrayList<String> getTipoDiscoDuro() {
		return tipoDiscoDuro;
	}

	public void setTipoDiscoDuro(ArrayList<String> tipoDiscoDuro) {
		this.tipoDiscoDuro = tipoDiscoDuro;
	}
	
}
