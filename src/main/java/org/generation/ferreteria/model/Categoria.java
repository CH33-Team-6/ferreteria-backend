package org.generation.ferreteria.model;

public class Categoria {
	private Long id;
	private String nCategoria;
	
	private static long total=0;
	
	public Categoria(String nCategoria) {
		this.nCategoria = nCategoria;
		Categoria.total++;
		this.id = total;
	}// constructorCategorias
	public Categoria() {
		Categoria.total++;
		this.id = total;
	}//constructor()
	public String getNCategoria() {
		return nCategoria;
	}
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
	
}
