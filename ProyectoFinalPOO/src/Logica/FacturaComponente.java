package Logica;

import java.util.ArrayList;

public class FacturaComponente extends Factura {
	private ArrayList<Componente> listaComponentes;
	
	public FacturaComponente(String idCliente, String id, Float montoTotal, ArrayList<Componente> listaComponentes) {
		super(idCliente, id, montoTotal);
		this.listaComponentes = listaComponentes;
	}

	public ArrayList<Componente> getCarrito() {
		return listaComponentes;
	}

	public void setCarrito(ArrayList<Componente> listaComponentes) {
		this.listaComponentes = listaComponentes;
	}

}
