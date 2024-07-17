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
	
	public static Tienda getInstance() {
		if(miTienda == null) {
			miTienda = new Tienda();
		}
		return miTienda;
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
		misComputadoras.remove(computadora);
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

	/*public float calcularTotal(Factura factura) {
		float precio = 0;
		int porcentaje = 0;
		if(factura instanceof FacturaComponente) {
			ArrayList<Componente>losComponentes = ((FacturaComponente) factura).getCarrito();
			for(Componente componente : losComponentes) {
				precio += componente.getPrecio();
				porcentaje = componente.getDescuento();
			}
		}
		else if(factura instanceof FacturaComputadora) {
			String id = FacturaComputadora.getIdComputadora();
			Computadora computadora = searchComputadoraById(id);
			ArrayList<Componente> aux = computadora.getComponentes();
			
			for(Componente componente : aux) {
				precio += componente.getPrecio();
				porcentaje = componente.getDescuento();
			}
		}
		
		if(porcentaje != 0) {
			precio = (float) (precio - ((porcentaje * precio) / 100));
		}
		
		return precio;
	}*/
	
	public float calcPrecioTotalComponente(Cliente cliente) {
		float precio = 0;
		int porcentaje = 0;
		float precioTotal = 0;
		ArrayList<Componente> aux = cliente.getCarrito();
		
		for(Componente componente : aux) {
			precio = componente.getPrecio();
			porcentaje = componente.getDescuento();
			precioTotal = (float) (precio - ((porcentaje * precio) / 100));
		}
		return precioTotal;
	}
	
	public float calcPrecioTotalComputadora(ArrayList<Componente> componentes) {
		float precio = 0;
		int porcentaje = 0;
		float precioTotal = 0;
		
		for(Componente componente : componentes) {
			precio = componente.getPrecio();
			porcentaje = componente.getDescuento();
			precioTotal = (float) (precio - ((porcentaje * precio) / 100));
		}
		return precioTotal;
	}
	
	public ArrayList<Componente> filterByMarca(String marca){
		ArrayList<Componente> componentesByMarca = new ArrayList<>();
		
		for ( Componente comp : misComponentes ) {
			if ( comp.getMarca().equals(marca) ) {
				componentesByMarca.add(comp);
			}
		}
		return componentesByMarca;
	}
	
	public ArrayList<Componente> filterByPrecio(float precioMinimo, float precioMaximo){
		ArrayList<Componente> componentesByPrecio = new ArrayList<>();
		
		for ( Componente comp : misComponentes ) {
			if ( comp.getPrecio() > precioMinimo && comp.getPrecio() < precioMaximo ) {
				componentesByPrecio.add(comp);
			}
		}
		return componentesByPrecio;
	}
	
	public boolean makeFactura(Componente componente, Computadora pc, Cliente cliente, Factura factura) {
		float precioTotal = 0;
		boolean op = false;
		if ( componente != null && factura instanceof FacturaComponente ) {
			precioTotal = calcPrecioTotalComponente(cliente);
			ArrayList<Componente> carrito = cliente.getCarrito();
			factura = new FacturaComponente(cliente.getId(), "F-" + codFactura, precioTotal, carrito);
			op = true;
		} else if ( pc != null && factura instanceof FacturaComputadora ) {
			precioTotal = calcPrecioTotalComputadora(pc.getComponentes());
			String id = pc.getId();
			factura = new FacturaComputadora(cliente.getId(), "F-" + codFactura, precioTotal, id);
			op = true;
		}
		factura.setComprado(true);
		insertarFactura(factura);
		return op;
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
	
	public boolean makeComputadora(String id, ArrayList<Componente> componentes, String tipo) {
		boolean creado = false;
		float precioPc = calcPrecioTotalComputadora(componentes);
		Computadora pc = new Computadora(id, componentes, precioPc, tipo);
		
		if ( isCompatible(pc) ) {
			creado = true;
			insertarComputadora(pc);
		}
		return creado;
	}
	
	public boolean isCompatible(Computadora pc) {
		boolean compatible = false;
		
		TarjetaMadre tarjetaMadre = ((TarjetaMadre) pc.getComponentes().get(0));
		Ram ram = ((Ram) pc.getComponentes().get(1));
		MicroProcesador microProcesador = ((MicroProcesador) pc.getComponentes().get(2));
		DiscoDuro discoDuro = ((DiscoDuro) pc.getComponentes().get(3));
		
		if( tarjetaMadre.getTipoRam().equals(ram.getTipoMemoria()) && 
			tarjetaMadre.getConectionSocket().equals(microProcesador.getTipoConexion()) ) {
			
			for ( String tipo : tarjetaMadre.getTipoDiscoDuro() ) {
				if ( tipo.equals(discoDuro.getTipoConexion()) ) {
					compatible = true;
					break;
				}
			}
			
		}
		return compatible;
	}

}
