package Logica;

import java.io.Serializable;

public class Factura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCliente;
	private String id;
	private Float montoTotal;
	private boolean comprado;
	
	public Factura(String idCliente, String id, Float montoTotal) {
		super();
		this.idCliente = idCliente;
		this.id = id;
		this.montoTotal = montoTotal;
		comprado = false;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getId() {
		return id;
	}
	
	public Float getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public boolean isComprado() {
		return comprado;
	}
	
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
}
