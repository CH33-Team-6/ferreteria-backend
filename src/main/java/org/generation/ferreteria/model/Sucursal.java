package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombreSucursal;
	@Column(nullable=false)
	private String ubicacion;
	@Column(nullable=false)
	private String telefono;


	public Sucursal(String nombreSucursal, String ubicacion, String telefono) {
		this.nombreSucursal = nombreSucursal;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
	}//constructor

	public Sucursal() {
	
	}//constructor

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
