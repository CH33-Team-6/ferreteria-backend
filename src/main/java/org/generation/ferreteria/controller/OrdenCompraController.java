package org.generation.ferreteria.controller;

import java.util.ArrayList;

import org.generation.ferreteria.model.OrdenCompra;
import org.generation.ferreteria.service.OrdenCompraService;
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
@RequestMapping(path="/api/ordenes/") // http://localhost:8080/api/ordenes/
public class OrdenCompraController {
	private final OrdenCompraService ordenCompraService;
	@Autowired
	public OrdenCompraController(OrdenCompraService ordenCompraService) {
		this.ordenCompraService = ordenCompraService;
	}//constructor
	@GetMapping
	public ArrayList<OrdenCompra> getAllOrdenCompra() {
        return ordenCompraService.getAllOrdenCompra();
    }
	@GetMapping(path="{ordId}")
    public OrdenCompra getOrdenCompra(@PathVariable("ordId") long id) {
        return ordenCompraService.getOrdenCompra(id);
    }
	@DeleteMapping(path = "{ordId}")
    public OrdenCompra deleteOrdenCompra(@PathVariable("ordId") long id) {
        return ordenCompraService.deleteOrdenCompra(id);
    }
	@PostMapping
    public OrdenCompra addOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.addOrdenCompra(ordenCompra);
    }
	@PutMapping(path = "{ordId}")
    public OrdenCompra updateOrdenCompra(
            @PathVariable("ordId") long id,
            @RequestParam(required = false) String fechaOrden,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double precioTotal,
            @RequestParam(required = false) Integer cantidadProductos){
        return ordenCompraService.updateOrdenCompra(id, fechaOrden, status, precioTotal, cantidadProductos);
    }
	
}
