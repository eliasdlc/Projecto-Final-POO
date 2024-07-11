package Logica;

import java.util.ArrayList;

public class FacturaComponente extends Factura {
	private ArrayList<Componente> carrito;
	
	public FacturaComponente(String idCliente, String id, Float montoTotal, boolean comprado) {
		super(idCliente, id, montoTotal, comprado);
		this.carrito = new ArrayList<>();
	}

	public ArrayList<Componente> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Componente> carrito) {
		this.carrito = carrito;
	}

}
