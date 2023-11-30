package org.generation.ferreteria.controller;

import java.util.ArrayList;

import org.generation.ferreteria.model.CarritoCompras;
import org.generation.ferreteria.service.CarritoComprasService;
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
@RequestMapping(path="/api/carrito/")

public class CarritoComprasController {
	private final CarritoComprasService carritoComprasService;
	@Autowired
	public CarritoComprasController(CarritoComprasService carritoComprasService) {
		this.carritoComprasService = carritoComprasService;
	}//constructor
	@GetMapping
	public ArrayList<CarritoCompras>getAllCarritoCompras(){
		return carritoComprasService.getAllCarritoCompras();
	}
	@GetMapping(path="{carId}")
	public CarritoCompras getCarritoCompras(@PathVariable("carId") long id) {
		return carritoComprasService.getCarritoCompras(id);
	}
	@DeleteMapping(path="{carId}")
	public CarritoCompras deleteCarritoCompras(@PathVariable("carId") long id) {
		return carritoComprasService.deleteCarritoCompras(id);
	}
	@PostMapping
	public CarritoCompras addCarritoCompras(@RequestBody CarritoCompras carritoCompras) {
		return carritoComprasService.addCarritoCompras(carritoCompras);
	}
	@PutMapping(path="{carId}")
	public CarritoCompras updateCarritoCompras(@PathVariable("carId") long id, 
		@RequestParam(required=false) String fechaCreacion,
		@RequestParam(required=false) Integer cantidadProducto,
		@RequestParam(required=false) Double precioTotal) {
		return carritoComprasService.updateCarritoCompras(id, fechaCreacion, cantidadProducto, precioTotal);
	}
	
}
