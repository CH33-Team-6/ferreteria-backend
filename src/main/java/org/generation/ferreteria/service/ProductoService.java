package org.generation.ferreteria.service;

import java.util.ArrayList;

import org.generation.ferreteria.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	@Autowired
	public ProductoService() {
			  lista.add(new Producto("Regleta Calibradora Truper",
			    "Regleta medidora de tuercas y tornillos, 22 cm, Truper ",
			     "Productos\1226REGLETATRUPER.jpg", 50.0));
			  lista.add(new Producto("Tijera forjada para poda ",
			    "Tijera forjada para poda 8 pulgadas para jardinería Truper", "Fotos Productos\024TIJERATRUPER.jpg", 165.0));
			  lista.add(new Producto("Nava Retráctil Truper",
					    "Cutter 18 mm profesional con alma metálica y grip, Truper",
					    "Productos/025Navaja", 81.00));
			  lista.add(new Producto("Separadores de losetas Truper",
					    " Bolsa con 75 separadores de 8 mm de losetas, Truper",
					    "Productos/072SeparadoresLoseta", 50.00));
	}//constructor
	public ArrayList<Producto> getAllProductos() {
		return lista;
	}
	public Producto getProducto(long id) {
		Producto prod = null;
		  for (Producto producto : lista) {
		   if(id == producto.getId()) {
		    prod = producto;
		    break;
		   }//if
		  }//foreach
		  return prod;
	}
	public Producto deleteProducto(long id) {
		  Producto prod = null;
		  for (Producto producto : lista) {
		   if(id == producto.getId()) {
		    prod = producto;
		    lista.remove(producto);
		    break;
		   }//if
		  }//foreach
		  return prod;
		 }
		 public Producto addProducto(Producto producto) {
		  lista.add(producto);
		  return producto;
		 }//addProducto
		 public Producto updateProducto(long id, String nombre, String descripcion, String imagen, Double precio) {
		  Producto prod = null;
		  for (Producto producto : lista) {
		   if(id == producto.getId()) {
		    //validar cual tiene valor
		    if(nombre != null) producto.setNombre(nombre);
		    if(descripcion != null) producto.setDescripcion(descripcion);
		    if(imagen != null) producto.setImagen(imagen);
		    if(precio != null) producto.setPrecio(precio);
		    prod=producto;
		    break;
		   }//if
		  }//foreach
		  return prod;
		 }//updateProducto
}//
