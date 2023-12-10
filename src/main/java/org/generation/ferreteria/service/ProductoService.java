package org.generation.ferreteria.service;

import java.util.List;
import java.util.Optional;

import org.generation.ferreteria.model.Producto;
import org.generation.ferreteria.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {
	public final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository= productoRepository;
	}//constructor
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}
	public Producto getProducto(long id) {
		  return productoRepository.findById(id).orElseThrow(
				  ()->new IllegalArgumentException("El producto con el Id ["
				  		+ "]no existe"));
	}//get producto
	
	public Producto deleteProducto(long id) {
		  Producto prod=null;
		  if (productoRepository.existsById(id)){
			  prod= productoRepository.findById(id).get();
			  productoRepository.deleteById(id);//vemos si existe para buscarlo
		  }//if
		  return prod;
		 }//detele
	
		 public Producto addProducto(Producto producto) {
		 Optional<Producto> tmpProd=productoRepository.findByNombre(producto.getNombre());
		 if (tmpProd.isEmpty()) {
			 return productoRepository.save(producto);
		 }//if
		 else {
			 System.out.println("Ya existe el producto con el nombre ["
			 		+ producto.getNombre() + "]");
			 return null;
		 }//else
		 }//addProducto
		 
		 public Producto updateProducto(Long id, String nombre, String imagen, Double precio, String descripcion, Double cantidad) {
		  Producto prod = null;
		   if(productoRepository.existsById(id)) {
		    
			prod=productoRepository.findById(id).get();
		    if(nombre != null) prod.setNombre(nombre);
		    if(descripcion != null) prod.setDescripcion(descripcion);
		    if(imagen != null) prod.setImagen(imagen);
		    if(precio != null) prod.setPrecio(precio);
		    if(cantidad != null) prod.setCantidad(cantidad);
		    productoRepository.save(prod);
		   }//if
		  return prod;
		 }//updateProducto
}//
