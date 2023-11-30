package org.generation.ferreteria.controller;

import java.util.ArrayList;

import org.generation.ferreteria.model.Sucursal;

import org.generation.ferreteria.service.SucursalService;
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
@RequestMapping(path="/api/sucursales/") // http://localhost:8080/api/sucursales/

public class SucursalController {
	private final SucursalService sucursalService;
	@Autowired
	public SucursalController(SucursalService sucursalService) {
		this.sucursalService = sucursalService;
	}//constructor
	@GetMapping
	public ArrayList<Sucursal> getAllSucursales(){
		return sucursalService.getAllSucursales();
	}//getAllSucursales
	@GetMapping(path="{sucId}")  //http://localhost:8080/api/sucursales/id
	public Sucursal getSucursal(@PathVariable("sucId") long id) {
		return sucursalService.getSucursal(id);
	}//getONESucursal
	@DeleteMapping(path="{sucId}") 
	public Sucursal deleteSucursal(@PathVariable("sucId") long id) {
		return sucursalService.deleteSucursal(id);
	}//getONESucursal
	@PostMapping
	public Sucursal addSucursal(@RequestBody Sucursal sucursal) {
		return sucursalService.addSucursal(sucursal);
	}
	
	@PutMapping
	public Sucursal updateSucursal(@PathVariable("sucId") long id,
			@RequestParam(required=false) String nombreSucursal,
			@RequestParam(required=false) String ubicacion,
			@RequestParam(required=false) String telefono) {
		return sucursalService.updateSucursal(id, nombreSucursal, ubicacion, telefono);
	}//PUTSucursal
	
	
}
