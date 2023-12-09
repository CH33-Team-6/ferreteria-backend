package org.generation.ferreteria.service;

import java.util.List;
import java.util.Optional;
import org.generation.ferreteria.model.Usuario;
import org.generation.ferreteria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository= usuarioRepository;
	}//constructor UsuarioService
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}//getAllUsuarios
	public Usuario getUsuario(long id) {
		
		return usuarioRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El usuario con el id ["
						+ "] no existe"));
	}//getUsuario
	public Usuario deleteUsuario(long id) {
		Usuario usu=null;
		if (usuarioRepository.existsById(id)) {
			usu=usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}//if
		return usu;
	}//deleteUsuario
	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> tmpUsu=usuarioRepository.findByEmail(usuario.getEmail());
		if (tmpUsu.isEmpty()) {
			return usuarioRepository.save(usuario);
		}//if
		else {
			System.out.println("El usuario ya se encuentra registrado con el nombre ["
					+ usuario.getEmail()+"]");
			return null;
		}//else
	}//addUsuario
	
	public Usuario updateUsuario(long id, String nombre, String password, String email) {
		Usuario usu=null;
			if(usuarioRepository.existsById(id)) {
				usu=usuarioRepository.findById(id).get();
				if(nombre!=null) usu.setNombre(nombre);
				if(password!=null) usu.setPassword(password);
				if(email!=null) usu.setEmail(email);
				usuarioRepository.save(usu);
			}//if
		return usu;
	}//updateProducto
	public boolean validateUser(Usuario usuario) {
		  Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
		  if(userByEmail.isPresent()) {
		   Usuario user = userByEmail.get();
		   if(passwordEncoder.matches(usuario.getPassword(), user.getPassword())) {
		//   if(user.getPassword().equals(usuario.getPassword())) {
		    return true;
		   }//equals password
		  }//isPresent
		  return false;
		 }//validateUser

	
}//class UsuarioService
