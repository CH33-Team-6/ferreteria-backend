package org.generation.ferreteria.model;
	
public class CarritoCompras {
	private Long id;
	private String fechaCreacion;
	private Integer cantidadProducto;
	private Double precioTotal;
	
	private static long total=0;

	public CarritoCompras(String fechaCreacion, int cantidadProducto, double precioTotal) {
		this.fechaCreacion = fechaCreacion;
		this.cantidadProducto = cantidadProducto;
		this.precioTotal = precioTotal;
		CarritoCompras.total++;
		this.id = total;
	}//constructor
	public CarritoCompras() {
		CarritoCompras.total++;
		this.id = total;
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
