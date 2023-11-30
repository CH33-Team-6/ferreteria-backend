package org.generation.ferreteria.service;

import java.util.ArrayList;

import org.generation.ferreteria.model.OrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService {
	public final ArrayList<OrdenCompra> lista = new ArrayList<OrdenCompra>();
	@Autowired
	public OrdenCompraService() {
		lista.add(new OrdenCompra("2023-11-11", "entregado",400.00,9));
		lista.add(new OrdenCompra("2023-10-01", "entregado",670.00,2));
		lista.add(new OrdenCompra("2023-08-19", "pendiente",960.00,4));
	}//constructor
	public ArrayList<OrdenCompra> getAllOrdenCompra(){
		return lista;
	}//getAllOrdenCompra
	public OrdenCompra getOrdenCompra(long id) {
		OrdenCompra oc = null;
		for (OrdenCompra ordenCompra : lista) {
			if(id == ordenCompra.getId()) {
				oc = ordenCompra;
				break;
			}//if
		}//for each
		return oc;
	}
	public OrdenCompra deleteOrdenCompra(long id) {
		OrdenCompra oc = null;
		for (OrdenCompra ordenCompra : lista) {
			if(id == ordenCompra.getId()) {
				oc = ordenCompra;
				lista.remove(ordenCompra);
				break;
			}//if
		}//for each
		return oc;
	}
	public OrdenCompra addOrdenCompra(OrdenCompra ordenCompra) {
		lista.add(ordenCompra);
		return ordenCompra;
	}
	public OrdenCompra updateOrdenCompra(long id, String fechaOrden, String status, Double precioTotal,
			Integer cantidadProductos) {
		OrdenCompra oc = null;
		for (OrdenCompra ordenCompra : lista) {
			if(id == ordenCompra.getId()) {
				if(fechaOrden != null) ordenCompra.setFechaOrden(fechaOrden);
				if(status != null) ordenCompra.setStatus(status);
				if(precioTotal != null) ordenCompra.setPrecioTotal(precioTotal);
				if(cantidadProductos != null) ordenCompra.setCantidadProductos(cantidadProductos);
				oc = ordenCompra;
				break;
			}//if
		}//for each
		return oc;
	}//updateProductos
	
	
}
