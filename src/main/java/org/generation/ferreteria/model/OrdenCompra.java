package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "orden_compra")
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
    private String fecha;
	@Column(nullable=false)
    private String status;
    private Double precio;
    private Integer cantidad;



	public OrdenCompra(String fechaOrden, String status, Double precioTotal, Integer cantidadProductos) {
		this.fecha = fechaOrden;
		this.status = status;
		this.precio = precioTotal;
		this.cantidad = cantidadProductos;
		
	}//constructor
	public OrdenCompra() {
		
	}//constructor
	public String getFechaOrden() {
		return fecha;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fecha = fechaOrden;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPrecioTotal() {
		return precio;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precio = precioTotal;
	}
	public Integer getCantidadProductos() {
		return cantidad;
	}
	public void setCantidadProductos(Integer cantidadProductos) {
		this.cantidad = cantidadProductos;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "OrdenCompra [id=" + id + ", fecha=" + fecha + ", status=" + status + ", precio="
				+ precio + ", cantidad=" + cantidad + "]";
	}  
}
