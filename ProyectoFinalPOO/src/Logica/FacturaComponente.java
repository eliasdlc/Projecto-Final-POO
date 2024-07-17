package Logica;

import java.util.ArrayList;

public class FacturaComponente extends Factura {
	private ArrayList<Componente> carrito;
	
	public FacturaComponente(String idCliente, String id, Float montoTotal, ArrayList<Componente> carrito) {
		super(idCliente, id, montoTotal);
		this.carrito = carrito;
	}

	public ArrayList<Componente> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Componente> carrito) {
		this.carrito = carrito;
	}

}
