package Logica;

public class Factura {
	
	private String idCliente;
	private String idComputadora;
	private String id;
	private Float montoTotal;
	private boolean comprado;
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdComputadora() {
		return idComputadora;
	}
	public void setIdComputadora(String idComputadora) {
		this.idComputadora = idComputadora;
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
