package Logica;

public class ComponentHolder {
	private Componente componenteElegido;
    private Componente componenteASeleccionar;

    public ComponentHolder(Componente elegido, Componente aSeleccionar) {
        this.componenteElegido = elegido;
        this.componenteASeleccionar = aSeleccionar;
    }

	public Componente getComponenteElegido() {
		return componenteElegido;
	}

	public void setComponenteElegido(Componente componenteElegido) {
		this.componenteElegido = componenteElegido;
	}

	public Componente getComponenteASeleccionar() {
		return componenteASeleccionar;
	}

	public void setComponenteASeleccionar(Componente componenteASeleccionar) {
		this.componenteASeleccionar = componenteASeleccionar;
	}
    
    
}
