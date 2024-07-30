package Logica;

import java.util.ArrayList;

public class FacturaComponente extends Factura {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] cantArticulos;
	private ArrayList<Componente> listaComponentes;

	public FacturaComponente(String idCliente, String id, Float montoTotal, int[] cantArticulos,
			ArrayList<Componente> listaComponentes) {
		super(idCliente, id, montoTotal);
		this.setCantArticulos(cantArticulos);
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
