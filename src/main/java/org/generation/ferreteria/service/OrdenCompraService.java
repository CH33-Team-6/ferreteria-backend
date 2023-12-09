package org.generation.ferreteria.service;

import java.util.List;
import java.util.Optional;

import org.generation.ferreteria.model.OrdenCompra;
import org.generation.ferreteria.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService {
	private final OrdenCompraRepository ordenCompraRepository;
	@Autowired
	public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
		this.ordenCompraRepository=ordenCompraRepository;
	}//constructor
	
	public List<OrdenCompra> getAllOrdenCompra(){
		return ordenCompraRepository.findAll();
	}//getAllOrdenCompra
	
	public OrdenCompra getOrdenCompra(long id) {
		return ordenCompraRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La orden de compra con el id ["
						+ "] no existe"));
	}//getOrdenCompra
	public OrdenCompra deleteOrdenCompra(long id) {
		OrdenCompra oc = null;
			if(ordenCompraRepository.existsById(id)) {
				oc = ordenCompraRepository.findById(id).get();
				ordenCompraRepository.deleteById(id);
			}//if
		return oc;
	}//deleteOrdenCompra
	
	public OrdenCompra addOrdenCompra(OrdenCompra ordenCompra) {
		Optional<OrdenCompra> tmpOc= ordenCompraRepository.findByFecha(ordenCompra.getFechaOrden());
		if (tmpOc.isEmpty()) {
			return ordenCompraRepository.save(ordenCompra);
		}//if
		else {
			System.out.println("Ya existe la orden de compra con la fechaOrden ["
					+ ordenCompra.getFechaOrden() +"]");
			return null;
		}//else
	}//addOrdenCompra
	
	public OrdenCompra updateOrdenCompra(long id, String fechaOrden, String status, Double precioTotal,Integer cantidadProductos) {
		OrdenCompra oc = null;
			if(ordenCompraRepository.existsById(id)) {
				oc = ordenCompraRepository.findById(id).get();
				if(fechaOrden != null) oc.setFechaOrden(fechaOrden);
				if(status != null) oc.setStatus(status);
				if(precioTotal != null) oc.setPrecioTotal(precioTotal);
				if(cantidadProductos != null) oc.setCantidadProductos(cantidadProductos);
				ordenCompraRepository.save(oc);
			}//if
			return oc;
	}//updateProductos
	
	
}
