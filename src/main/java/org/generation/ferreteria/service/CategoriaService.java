package org.generation.ferreteria.service;

import java.util.List;
import java.util.Optional;

import org.generation.ferreteria.model.Categoria;
import org.generation.ferreteria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	public final CategoriaRepository categoriaRepository;
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
			  this.categoriaRepository= categoriaRepository; 
	}//Contructor
	
	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}//getAllCategorias
	public Categoria getCategoria(long id) {
		return categoriaRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("La categoría con el id["
						+ "] no existe"));
	}//getCategoria
	public Categoria deleteCategoria(long id) {
		Categoria cat=null;
		if (categoriaRepository.existsById(id))
		{ cat = categoriaRepository.findById(id).get();
		  categoriaRepository.deleteById(id);
		}//if
		return cat;
	}//deleteCategoria
	
	public Categoria addCategoria(Categoria categoria) {
		Optional<Categoria> tmpCat=categoriaRepository.findBynCategoria(categoria.getNCategoria());
		if(tmpCat.isEmpty()){
			return categoriaRepository.save(categoria);
		}//if
		else {
			System.out.println("Ya existe la categoría con el nombre ["
					+ categoria.getNCategoria() +"]");
			return null;
		}//else
	}//addCategoria
	
	public Categoria updateCategoria(long id, String nCategoria) {
		Categoria cat = null;
			if(categoriaRepository.existsById(id)) {
				cat = categoriaRepository.findById(id).get();
				if(nCategoria != null) cat.setNCategoria(nCategoria);
				categoriaRepository.save(cat);
			}//if
		return cat;
	}//update
	
}//class categoriaService
