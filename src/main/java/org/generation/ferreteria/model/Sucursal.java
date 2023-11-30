package org.generation.ferreteria.model;

public class Sucursal {
	private Long id;
	private String nombreSucursal;
	private String ubicacion;
	private String telefono;

	
	private static long total=0;


	public Sucursal(String nombreSucursal, String ubicacion, String telefono) {
		this.nombreSucursal = nombreSucursal;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		Sucursal.total++;
		this.id = total;
	}

	public Sucursal() {
		Sucursal.total++;
		this.id = total;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", nombreSucursal=" + nombreSucursal + ", ubicacion=" + ubicacion + ", telefono="
				+ telefono + "]";
	}
		
}
