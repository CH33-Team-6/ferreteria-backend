package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CarritoCompras")
public class CarritoCompras {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id", unique=true, nullable=false)
	private Long id;
@Column(nullable=false)
	private String fechaCreacion;
@Column(nullable=false)
	private Integer cantidadProducto;
@Column(nullable=false)
	private Double precioTotal;
	
	public CarritoCompras(String fechaCreacion, int cantidadProducto, double precioTotal) {
		this.fechaCreacion = fechaCreacion;
		this.cantidadProducto = cantidadProducto;
		this.precioTotal = precioTotal;
		
	}//constructor
	public CarritoCompras() {
		
	}//constructor
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "CarritoCompras [id=" + id + ", fechaCreacion=" + fechaCreacion + ", cantidadProducto="
				+ cantidadProducto + ", precioTotal=" + precioTotal + "]";
	}
	
}//class CarritoCompras
