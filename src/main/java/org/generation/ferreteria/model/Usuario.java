package org.generation.ferreteria.model;

public class Usuario {
	private Long id;
	private String nombre;
	private String numero;
	private String correo;
	 
	 
	 private static long total=0;


	public Usuario(String nombre, String numero, String correo) {
		this.nombre = nombre;
		this.numero = numero;
		this.correo = correo;
	}//constructor
	public Usuario() {
		Usuario.total++;
		this.id = total;
	}//constructor
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", numero=" + numero + ", correo=" + correo + "]";
	}
}
