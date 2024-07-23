package Logica;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	
	private String conectionSocket;
	private String tipoRam;
	private String conectionGPU;
	private ArrayList<String> tipoDiscoDuro;

	public TarjetaMadre(String id, String marca, String modelo, float precio, int cantDisponible, int cantVendidos
			, String conectionSocket, String tipoRam, String conectionGPU, ArrayList<String> tipoDiscoDuro) {
		super(id, marca, modelo, precio, cantDisponible, cantVendidos);
		this.conectionSocket = conectionSocket;
		this.tipoRam = tipoRam;
		this.conectionGPU = conectionGPU;
		this.tipoDiscoDuro = tipoDiscoDuro;
	}

	public String getConectionSocket() {
		return conectionSocket;
	}

	public void setConectionSocket(String conectionSocket) {
		this.conectionSocket = conectionSocket;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}

	public String getConectionGPU() {
		return conectionGPU;
	}

	public void setConectionGPU(String conectionGPU) {
		this.conectionGPU = conectionGPU;
	}

	public ArrayList<String> getTipoDiscoDuro() {
		return tipoDiscoDuro;
	}

	public void setTipoDiscoDuro(ArrayList<String> tipoDiscoDuro) {
		this.tipoDiscoDuro = tipoDiscoDuro;
	}
	
}
