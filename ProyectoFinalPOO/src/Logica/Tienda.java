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
		this.misComputadoras = new ArrayList<Computadora>();
	}
	
	public static Tienda getInstance() {
		if(miTienda == null) {
			miTienda = new Tienda();
		} return miTienda;
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

	public ArrayList<Computadora> getMisComputadoras() {
		return misComputadoras;
	}

	public static int getCodCliente() {
		return codCliente;
	}

	public static int getCodComponente() {
		return codComponente;
	}

	public static int getCodFactura() {
		return codFactura;
	}

	public static int getCodComputadora() {
		return codComputadora;
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
	
	public void setMisComputadoras(ArrayList<Computadora> misComputadoras) {
		this.misComputadoras = misComputadoras;
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
	
	public void deleteCliente(String idcliente) {
		Cliente cliente = searchClienteById(idcliente);
		misClientes.remove(cliente);
	}
	
	public void deleteComponente(String idcomponente) {
		Componente componente = searchComponenteById(idcomponente);
		misComponentes.remove(componente);
	}
	
	public void deleteFactura(String idfactura) {
		Factura factura = searchFacturaById(idfactura);
		misFacturas.remove(factura);
	}
	
	public void deleteComputadora(String idcomputadora) {
		Computadora computadora = searchComputadoraById(idcomputadora);
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
	
	public boolean makeFactura(ArrayList<Componente> componentes, Computadora pc, Cliente cliente) {
	    float precioTotal = 0;
	    boolean finalizado = false;
	    Factura factura = null;
	    String id = "F-" + codFactura;

	    if (!componentes.isEmpty() && pc == null) {
	        precioTotal = calcPrecioTotalComponente(cliente);
	        ArrayList<Componente> carrito = cliente.getCarrito();
	        int[] cantArticulos = calcularCantidadArticulos(carrito);
	        factura = new FacturaComponente(cliente.getId(), id, precioTotal, cantArticulos, carrito);
	        finalizado = true;
	    } else if (pc != null && componentes.isEmpty()) {
	        precioTotal = calcPrecioTotalComputadora(pc.getComponentes());
	        factura = new FacturaComputadora(cliente.getId(), id, precioTotal, 1, pc.getId());
	        finalizado = true;
	    }

	    if (finalizado) {
	        factura.setComprado(true);
	        insertarFactura(factura);
	    }

	    return finalizado;
	}

	private int[] calcularCantidadArticulos(ArrayList<Componente> carrito) {
	    int[] cantidadArticulos = new int[carrito.size()];
	    
	    for (int i = 0; i < carrito.size(); i++) {
	        cantidadArticulos[i] = carrito.get(i).getCantSeleccionado();
	    }
	    
	    return cantidadArticulos;
	}
	
	public boolean makeOferta(Componente componente) {
		boolean oferta = false;
		int cantVendido = componente.getCantVendidos();
		if(cantVendido > 15) {
			componente.setDescuento(componente.getDescuento() + 15);
			oferta = true;
		}
		else if(cantVendido <= 15) {
			componente.setDescuento(componente.getDescuento()+ 10);
			oferta = true;
		}
		else if(cantVendido <= 10) {
			componente.setDescuento(componente.getDescuento() + 5);
			oferta = true;
		}
		return oferta;
	}
	
	public boolean makeComputadora(String id, ArrayList<Componente> componentes, int cantDisponibles, String tipo) {
		boolean creado = false;
		float precioPc = calcPrecioTotalComputadora(componentes);
		Computadora pc = new Computadora(id, componentes, precioPc, cantDisponibles, tipo);
		
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
				for ( String tipo2 : discoDuro.getTipoConexiones() ) {
					if ( tipo.equals(tipo2) ) {
						compatible = true;
						break;
					}
				}
				
			}
			
		}
		return compatible;
	}

}
