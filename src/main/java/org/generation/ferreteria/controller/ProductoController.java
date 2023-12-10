package org.generation.ferreteria.controller;

import java.util.List;

import org.generation.ferreteria.model.Producto;
import org.generation.ferreteria.service.ProductoService;
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
@RequestMapping(path="/api/productos/") // http://localhost:8080/api/productos/

public class ProductoController {
private final ProductoService productoService;
@Autowired
public ProductoController(ProductoService productoService) {
 this.productoService = productoService;
}//constructor que va a inicializar el productoService
@GetMapping
public List<Producto> getAllProductos(){
 return productoService.getAllProductos();
}
@GetMapping(path="{prodId}")  //http://localhost:8080/api/productos/id
public Producto getProducto(@PathVariable("prodId") long id){
 return productoService.getProducto(id);
}//getProducto
@DeleteMapping(path="{prodId}")  //http://localhost:8080/api/productos/id
public Producto deleteProducto(@PathVariable("prodId") long id){
 return productoService.deleteProducto(id);
}//deleteProducto
@PostMapping   //http://localhost:8080/api/productos/id
public Producto addProducto(@RequestBody Producto producto){
 return productoService.addProducto(producto);
}//addProducto
@PutMapping(path="{prodId}")
public Producto updateProducto(@PathVariable("prodId") Long id,
  @RequestParam(required=false) String nombre,
  @RequestParam(required=false) String imagen,
  @RequestParam(required=false) Double precio,
  @RequestParam(required=false) String descripcion,
  @RequestParam(required=false) Double cantidad){
 return productoService.updateProducto(id,nombre, imagen, precio, descripcion, cantidad);
}//requestparam
}//class productorController