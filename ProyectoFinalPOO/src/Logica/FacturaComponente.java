package Logica;

import java.util.ArrayList;
import java.util.Date;

public class FacturaComponente extends Factura {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] cantArticulos;
	private ArrayList<Componente> listaComponentes;

	

	public FacturaComponente(String idCliente, String id, Float subTotal, Float descuento, Float montoTotal, Date fecha,
			int[] cantArticulos, ArrayList<Componente> listaComponentes) {
		super(idCliente, id, subTotal, descuento, montoTotal, fecha);
		this.cantArticulos = cantArticulos;
		this.listaComponentes = listaComponentes;
	}

	public ArrayList<Componente> getCarrito() {
		return listaComponentes;
	}

	public void setCarrito(ArrayList<Componente> listaComponentes) {
		this.listaComponentes = listaComponentes;
	}

	public int[] getCantArticulos() {
		return cantArticulos;
	}

	public void setCantArticulos(int[] cantArticulos) {
		this.cantArticulos = cantArticulos;
	}

}
