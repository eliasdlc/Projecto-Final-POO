package Logica;

import java.util.ArrayList;

public class Tienda {
	private ArrayList<Cliente> misClientes;
	private ArrayList<Componente> misComponentes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Computadora> misComputadoras;
	private static Tienda miTienda = null; 
	public static int codCliente = 1;
	public static int codComponente = 1;
	public static int codFactura = 1;
	public static int codComputadora = 1;
	
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
	
	public void insertarComputadora(Computadora computadora) {
		misComputadoras.add(computadora);
		codComputadora++;
	}
	
	public void updateCliente(Cliente cliente, int ind) {
		misClientes.set(ind, cliente);
	}
	
	public void updateComponente(Componente componente, int ind) {
		misComponentes.set(ind, componente);
	}
	
	public void updateFactura(Factura factura, int ind) {
		misFacturas.set(ind, factura);
	}
	
	public void updateComputadora(Computadora computadora, int ind) {
		misComputadoras.set(ind, computadora);
	}
	
	public void deleteCliente(Cliente cliente) {
		misClientes.remove(cliente);
	}
	
	public void deleteComponente(Componente componente) {
		misComponentes.remove(componente);
	}
	
	public void deleteFactura(Factura factura) {
		misFacturas.remove(factura);
	}
	
	public void deleteComputadora(Computadora computadora) {
		misFacturas.remove(computadora);
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
			i++;
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
			i++;
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
			i++;
		}
		return factura;
	}
	
	public Computadora searchComputadoraById(String id) {
		Computadora computadora = null;
		boolean encontrado = false;
		int ind = 0;
		
		while(!encontrado && ind < misComputadoras.size()) {
			if(misComputadoras.get(ind).getId().equalsIgnoreCase(id)) {
				encontrado = true;
				computadora = misComputadoras.get(ind);
			}
			ind++;
		}
		return computadora;
	}

	public float calcularTotal(Factura factura) {
		int ind = 0;
		float precio = 0;
		int porcentaje = 0;
		if(factura instanceof FacturaComponente) {
			ArrayList<Componente>losComponentes = ((FacturaComponente) factura).getCarrito();
			for(Componente componente : losComponentes) {
				precio += (float) componente.getPrecio();
				porcentaje = componente.getDescuento();
			}
		}
		else if(factura instanceof FacturaComputadora) {
			String id = FacturaComputadora.getIdComputadora();
			Computadora computadora = searchComputadoraById(id);
			ArrayList<Componente> aux = computadora.getComponentes();
			
			for(Componente componente : aux) {
				precio += (float) componente.getPrecio();
				porcentaje = componente.getDescuento();
			}
		}
		
		if(porcentaje != 0) {
			precio = (float) (precio - ((porcentaje * precio) / 100));
		}
		
		return precio;
	}
	
	public void makeOferta(Componente componente) {
		int cantVendido = componente.getCantVendidos();
		if(cantVendido > 15) {
			componente.setDescuento(componente.getDescuento() + 15);
		}
		else if(cantVendido <= 15) {
			componente.setDescuento(componente.getDescuento()+ 10);
		}
		else if(cantVendido <= 10) {
			componente.setDescuento(componente.getDescuento() + 5);
	
		}

	}

}
