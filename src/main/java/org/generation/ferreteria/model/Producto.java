package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")//nombre de la tabla en base de datos
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String imagen;
	@Column(nullable = false)
	private Double precio;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private Double cantidad;
	public Producto(String nombre, String imagen, Double precio, String descripcion, Double cantidad) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
	}
	
}//Class producto