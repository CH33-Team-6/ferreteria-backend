package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrito")
public class CarritoCompras {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id", unique=true, nullable=false)
	private Long id;
@Column(nullable=false)
	private String fecha;
@Column(nullable=false)
	private Integer cantidad;
@Column(nullable=false)
	private Double precio;
	
	
	public CarritoCompras(String fecha, Integer cantidad, Double precio) {
	
	this.fecha = fecha;
	this.cantidad = cantidad;
	this.precio = precio;
}
	public CarritoCompras() {
		
	}//constructor
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
		return "CarritoCompras [id=" + id + ", fecha=" + fecha + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
}//class CarritoCompras
