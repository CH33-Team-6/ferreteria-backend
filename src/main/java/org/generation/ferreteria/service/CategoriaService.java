package org.generation.ferreteria.service;

import java.util.ArrayList;

import org.generation.ferreteria.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	public final ArrayList<Categoria> lista = new ArrayList<Categoria>();
	@Autowired
	public CategoriaService() {
			  lista.add(new Categoria("herramientas"));
			  lista.add(new Categoria("jardineria"));
			  lista.add(new Categoria("refacciones"));
	}//
	public ArrayList<Categoria> getAllCategorias() {
		return lista;
	}
	public Categoria getCategoria(long id) {
		Categoria cat = null;
		for(Categoria categoria : lista) {
			if(id == categoria.getId()) {
				cat = categoria;
				break;
			}//if
		}//for each
		return cat;
	}
	public Categoria deleteCategoria(long id) {
		Categoria cat = null;
		for(Categoria categoria : lista) {
			if(id == categoria.getId()) {
				cat = categoria;
				lista.remove(categoria);
				break;
			}//if
		}//for each
		return cat;
	}//deleteCategoria
	public Categoria addCategoria(Categoria categoria) {
		lista.add(categoria);
		return categoria;
	}//addCategoria
	public Categoria updateCategoria(long id, String nCategoria) {
		Categoria cat = null;
		for(Categoria categoria : lista) {
			if(id == categoria.getId()) {
				if(nCategoria != null) categoria.setNCategoria(nCategoria);
				cat = categoria;
				break;
			}//if
		}//for each
		return cat;
	}//update
}//class categoriaService
