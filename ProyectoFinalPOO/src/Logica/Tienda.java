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
	
	public Componente searchComponenteMasVendido() {
		Componente componenteMasVendido = new Componente(null, null, null, 0, 0, 0); // Poner que el componente al menos tenga 0 unidadades vendidas
		
		for ( int i = 0; i < misComponentes.size(); i++ ) {
			if ( misComponentes.get(i).getCantVendidos() > componenteMasVendido.getCantVendidos() ) {
				componenteMasVendido = misComponentes.get(i);
			}
		}
		return componenteMasVendido;
	}
	
	public Componente searchComponenteById(String id) {
		Componente componente = null;
		boolean encontrado = false;
		int i = 0;
		
		while ( !encontrado && i < misComponentes.size() ) {
			if ( misComponentes.get(i).getId().equals(id) ) {
				encontrado = true;
				componente = misComponentes.get(i);
			}
		}
		return componente;
	}
	
	public ArrayList<Componente> getListComponentesMasVendidos(){
		ArrayList<Componente> componentesMasVendidos = new ArrayList<>();
		
		Componente componenteMasFamoso = new Componente(null, null, null, 0, 1, 0);
		
		for ( Componente comp : misComponentes ) {
			if ( comp.getCantVendidos() > componenteMasFamoso.getCantVendidos() ) {
				componentesMasVendidos.add(comp);
			}
		}
		
		return componentesMasVendidos;
	}
	
	public Cliente searchClienteById(String id) {
		Cliente cliente = null;
		boolean encontrado = false;
		int i = 0;
		
		while ( !encontrado && i < misClientes.size() ) {
			if ( misClientes.get(i).getId().equals(id) ) {
				encontrado = true;
				cliente = misClientes.get(i);
			}
		}
		return cliente;
	}
	
	public Factura searchFacturaById(String id) {
		Factura factura = null;
		boolean encontrado = false;
		int i = 0;
		
		while ( !encontrado && i < misFacturas.size() ) {
			if ( misFacturas.get(i).getId().equals(id) ) {
				encontrado = true;
				factura = misFacturas.get(i);
			}
		}
		return factura;
	}
}
