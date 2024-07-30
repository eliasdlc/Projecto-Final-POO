package Logica;

import java.io.Serializable;

public class Usuarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String usuario;
	private String password;
	private String nombre;
	private String direccion;
	private String correo;
	private String telefono;
	
	public Usuarios(String usuario, String password, String nombre, String direccion, String telefono, String correo) {
		super();
		this.correo = correo;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.usuario = usuario;
		this.password = password;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
