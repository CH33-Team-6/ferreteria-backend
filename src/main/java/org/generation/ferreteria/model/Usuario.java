package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String correo;
	

	public Usuario(String nombre, String password, String correo) {
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
	}//constructor
	public Usuario() {
		
	}//constructor vacio
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", correo=" + correo + "]";
	}//toString
	
}
