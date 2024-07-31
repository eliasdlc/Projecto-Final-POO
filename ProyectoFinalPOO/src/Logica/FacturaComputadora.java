package Logica;

import java.util.ArrayList;
import java.util.Date;

public class FacturaComputadora extends Factura {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantComputadoras;
	private String idComputadora;
	private ArrayList<Componente> componentesPc;
	private int cantidad;

	

	public FacturaComputadora(String idCliente, String id, Float subTotal, Float descuento, Float montoTotal,
			Date fecha, int cantComputadoras, String idComputadora, ArrayList<Componente> componentesPc, int cantidad) {
		super(idCliente, id, subTotal, descuento, montoTotal, fecha);
		this.cantComputadoras = cantComputadoras;
		this.idComputadora = idComputadora;
		this.componentesPc = componentesPc;
		this.cantidad = cantidad;
	}

	public int getCantComputadoras() {
		return cantComputadoras;
	}
	
	public void setCantComputadoras(int cantComputadoras) {
		this.cantComputadoras = cantComputadoras;
	}

	public String getIdComputadora() {
		return idComputadora;
	}

	public void setIdComputadora(String idComputadora) {
		this.idComputadora = idComputadora;
	}

	public ArrayList<Componente> getComponentesPc() {
		return componentesPc;
	}

	public void setComponentesPc(ArrayList<Componente> componentesPc) {
		this.componentesPc = componentesPc;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}

