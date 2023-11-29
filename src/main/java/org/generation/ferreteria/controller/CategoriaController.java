package org.generation.ferreteria.controller;

import java.util.ArrayList;

import org.generation.ferreteria.model.Categoria;
import org.generation.ferreteria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/categorias/")

public class CategoriaController {
	private final CategoriaService categoriaService;
@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}//constructor
@GetMapping
public ArrayList<Categoria> getAllCategorias(){
 return categoriaService.getAllCategorias();
}//getMapping 
@GetMapping(path="{catId}")
public Categoria getCategoria(@PathVariable("catId") long id) {
	return categoriaService.getCategoria(id);
}//getMapping 1 producto
@DeleteMapping(path="{catId}")
public Categoria deleteCategoria(@PathVariable("catId") long id) {
	return categoriaService.deleteCategoria(id);
}//delete
@PostMapping(path="{catId}")
public Categoria addCategoria(@RequestBody Categoria categoria) {
	return categoriaService.addCategoria(categoria);
}//addProduct
@PutMapping(path="{catId}")
public Categoria updateCategoria(@PathVariable("prodId") long id,
		@RequestParam(required=false) String categoria) {
	return categoriaService.updateCategoria(id, categoria);
}
}
