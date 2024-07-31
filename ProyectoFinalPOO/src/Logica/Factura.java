package Logica;

import java.io.Serializable;
import java.util.Date;

public class Factura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCliente;
	private String id;
	private Float subTotal;
	private Float descuento;
	private Float montoTotal;
	private Date fecha;
	
	

	public Factura(String idCliente, String id, Float subTotal, Float descuento, Float montoTotal, Date fecha) {
		super();
		this.idCliente = idCliente;
		this.id = id;
		this.subTotal = subTotal;
		this.descuento = descuento;
		this.montoTotal = montoTotal;
		this.fecha = fecha;
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

	public Float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
