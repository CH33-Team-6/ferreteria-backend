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
	private String descripcion;
	private String imagen;
	private Double precio;
	
	
	
public Producto(String nombre, String descripcion, String imagen, Double precio) {
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.imagen = imagen;
	this.precio = precio;

}//Constructor
public Producto() {
}//Constructor
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
public Long getId() {
	return id;
}
@Override
public String toString() {
	return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
			+ ", precio=" + precio + "]";
}

}//Class producto