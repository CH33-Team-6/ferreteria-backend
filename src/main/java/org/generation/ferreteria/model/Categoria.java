package org.generation.ferreteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//autoincrementa
	@Column(name="id", unique=true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nCategoria;
	
	public Categoria(String nCategoria) {
		this.nCategoria = nCategoria;
		
	}// constructorCategorias
	public Categoria() {
		
	}//constructor()
	public String getNCategoria() {
		return nCategoria;
	}//constructor
	public void setNCategoria(String nCategoria) {
		this.nCategoria = nCategoria;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Categorias [id=" + id + ", categoria=" + nCategoria + "]";
	}
	
}//class categoria
