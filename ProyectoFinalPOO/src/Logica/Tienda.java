package Logica;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Cliente> misClientes;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private static Tienda miTienda = null; 
	public static int codCliente = 1;
	public static int codComponente = 1;
	public static int codFactura = 1;
	
	public Tienda() {
		super();
		this.misClientes = new ArrayList<Cliente>();
		this.misComponentes = new ArrayList<Componente>();
		this.misFacturas = new ArrayList<Factura>();
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}
	
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public static Tienda getInstance() {
		if(miTienda == null) {
			miTienda = new Tienda();
		}
		return miTienda;
	}
	
	public void insertarCliente(Cliente cliente) {
		misClientes.add(cliente);
		codCliente++;
	}
	
	public void insertarFactura(Factura factura) {
		misFacturas.add(factura);
		codFactura++;
	}
	
	public void insertarComponente(Componente componente) {
		misComponentes.add(componente);
		codComponente++;
	}
}
