package org.generation.ferreteria.model;

public class OrdenCompra {
	private Long id;
    private String fechaOrden;
    private String status;
    private Double precioTotal;
    private Integer cantidadProductos;

    private static long total=0;

	public OrdenCompra(String fechaOrden, String status, Double precioTotal, Integer cantidadProductos) {
		this.fechaOrden = fechaOrden;
		this.status = status;
		this.precioTotal = precioTotal;
		this.cantidadProductos = cantidadProductos;
		OrdenCompra.total++;
		this.id = total;
	}//constructor
	public OrdenCompra() {
		OrdenCompra.total++;
		this.id = total;
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
