package org.generation.ferreteria.controller;

import java.util.List;

import org.generation.ferreteria.model.Usuario;
import org.generation.ferreteria.service.UsuarioService;
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
@RequestMapping(path="/api/usuarios/") 

public class UsuarioController {
	private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		
	}//constructor
	@GetMapping
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getAllUsuarios();
	}//getAllUsuarios
	@GetMapping (path="{usuId}") // http://localhost:8080/api/usuarios/1
	public Usuario getUsuario(@PathVariable("usuId") long id){
		return usuarioService.getUsuario(id);
	}//getProducto
	
	@DeleteMapping (path="{usuId}") // http://localhost:8080/api/usuarios/1
	public Usuario deleteUsuario(@PathVariable("usuId") long id){
		return usuarioService.deleteUsuario(id);
	}//deleteProducto
	
	@PostMapping 
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}//addProducto
	
	@PutMapping (path="{usuId}") 
	public Usuario updateUsuario(@PathVariable("usuId") long id, 
			@RequestParam(required=false)String nombre,
			@RequestParam(required=false)String numero,
			@RequestParam(required=false)String correo){
	
		return usuarioService.updateUsuario(id, nombre, numero, correo);
	}//updateProducto
}