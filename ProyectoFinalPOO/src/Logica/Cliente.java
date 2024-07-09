package Logica;

public class Cliente {
	private String idclliente;
	private String nombre;
	private String correo;
	private String desc;
	
	public Cliente(String idclliente, String nombre, String correo, String desc) {
		super();
		this.idclliente = idclliente;
		this.nombre = nombre;
		this.correo = correo;
		this.desc = desc;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getIdclliente() {
		return idclliente;
	}
	
}
