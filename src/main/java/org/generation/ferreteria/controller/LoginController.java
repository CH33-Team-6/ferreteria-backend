package org.generation.ferreteria.controller;

import javax.servlet.ServletException;

import org.generation.ferreteria.config.JwtFilter;
import org.generation.ferreteria.model.Token;
import org.generation.ferreteria.model.Usuario;
import org.generation.ferreteria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="api/login/")
public class LoginController {
private final UsuarioService usuarioService;
@Autowired
public LoginController(UsuarioService usuarioService) {
	this.usuarioService = usuarioService;
}//contructor
@PostMapping
public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException {
	//validad que usuario y contraseña existan
	if (usuarioService.validateUser(usuario)) {
		System.out.println ("usuario válido" + usuario.getCorreo());
		return new Token (generateToken(usuario.getCorreo()));
	}//if
	throw new ServletException ("Nombre de usuario o contraseña incorrectos");
}//loginUsuario

private String generateToken(String username) {
	Calendar calendar = Calendar.getInstance();//Fecha hora actual
	calendar.add(Calendar.HOUR, 10); // Pruebas
	//calendar.add(Calendar.MINUTE, 30);// Producción
	return Jwts.builder().setSubject(username).claim("role", "user")
	.setIssuedAt(new Date())
	.setExpiration(calendar.getTime())
	.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
	.compact();//lo convierte a String para poderlo regresar
}//generateToken

}//class LoginController