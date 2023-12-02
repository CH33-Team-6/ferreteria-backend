package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "ordencompra")
public class OrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
    private String fechaOrden;
	@Column(nullable=false)
    private String status;
    private Double precioTotal;
    private Integer cantidadProductos;



	public OrdenCompra(String fechaOrden, String status, Double precioTotal, Integer cantidadProductos) {
		this.fechaOrden = fechaOrden;
		this.status = status;
		this.precioTotal = precioTotal;
		this.cantidadProductos = cantidadProductos;
		
	}//constructor
	public OrdenCompra() {
		
	}//constructor
	public String getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Integer getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(Integer cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "OrdenCompra [id=" + id + ", fechaOrden=" + fechaOrden + ", status=" + status + ", precioTotal="
				+ precioTotal + ", cantidadProductos=" + cantidadProductos + "]";
	}  
}
