package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sucursal")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String sucursal;
	@Column(nullable=false)
	private String ubicacion;
	@Column(nullable=false)
	private String telefono;


	public Sucursal(String sucursal, String ubicacion, String telefono) {
		this.sucursal = sucursal;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
	}//constructor

	public Sucursal() {
	
	}//constructor

	public String getNombreSucursal() {
		return sucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.sucursal = nombreSucursal;
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
		return "Sucursal [id=" + id + ", sucursal=" + sucursal + ", ubicacion=" + ubicacion + ", telefono="
				+ telefono + "]";
	}
		
}
