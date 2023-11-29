package org.generation.ferreteria.model;

public class Producto {
private Long id;
private String nombre;
private String descripcion;
private String imagen;
private Double precio;
private static long total=0;
public Producto(String nombre, String descripcion, String imagen, Double precio) {
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.imagen = imagen;
	this.precio = precio;
	Producto.total++;
	  this.id = total;
}//Constructor
public Producto() {
	Producto.total++;
	  this.id = total;
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