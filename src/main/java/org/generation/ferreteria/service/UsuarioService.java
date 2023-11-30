package org.generation.ferreteria.service;

import java.util.ArrayList;

import org.generation.ferreteria.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	public final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	@Autowired
	public UsuarioService() {
		lista.add(new Usuario ("Veronika", "55-30-58-34-23", "vero@gmail.com"));
		lista.add(new Usuario ("Gabriela", "55-65-78-23-50", "gaby@gmail.com"));
		lista.add(new Usuario ("Lilia", "55-90-34-21-24", "lili@gmail.com"));
		
	}//constructor UsuarioService
	public ArrayList<Usuario> getAllUsuarios() {
		
		return lista;
	}//getAllUsuarios
	public Usuario getUsuario(long id) {
		Usuario usu=null;
		for (Usuario usuario : lista) {
			if(id == usuario.getId()) {
				usu=usuario;
				break;
			}//if
		}//foreach
		return usu;
	}//getUsuario
	public Usuario deleteUsuario(long id) {
		Usuario usu=null;
		for (Usuario usuario : lista) {
			if(id == usuario.getId()) {
				usu=usuario;
				lista.remove(usuario);
				break;
			}//if
		}//foreach
		return usu;
	}//deleteUsuario
	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}//addUsuario
	public Usuario updateUsuario(long id, String nombre, String numero, String correo) {
		Usuario usu=null;
		for (Usuario usuario : lista) {
			if(id == usuario.getId()) {
				if(nombre!=null) usuario.setNombre(nombre);
				if(numero!=null) usuario.setNumero(numero);
				if(correo!=null) usuario.setCorreo(correo);
				usu=usuario;
				break;
			}//if
			
		}//foreach
		return usu;
	}//updateProducto

	
}//class UsuarioService
