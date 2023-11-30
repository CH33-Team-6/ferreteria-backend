package org.generation.ferreteria.service;

import java.util.ArrayList;

import org.generation.ferreteria.model.CarritoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CarritoComprasService {
	public final ArrayList<CarritoCompras> lista = new ArrayList<CarritoCompras>();
	@Autowired
	public CarritoComprasService() {
		lista.add(new CarritoCompras("2023-08-05", 1, 265.00));
		lista.add(new CarritoCompras("2023-09-25", 3, 952.00));
		lista.add(new CarritoCompras("2023-10-57", 2, 523.00));
	}//constructor
	public ArrayList<CarritoCompras> getAllCarritoCompras() {
		return lista;
	}//metodo getAll
	public CarritoCompras getCarritoCompras(long id) {
		CarritoCompras car = null;
		for (CarritoCompras carritoCompras : lista) {
			if(id == carritoCompras.getId()) {
				car=carritoCompras;
				break;
			}//if
		}//foreach
		return car;
	}//getCarritoCompras
	public CarritoCompras deleteCarritoCompras(long id) {
		CarritoCompras car = null;
		for (CarritoCompras carritoCompras : lista) {
			if(id == carritoCompras.getId()) {
				car=carritoCompras;
				lista.remove(carritoCompras);
				break;
			}//if
		}//foreach
		return car;
	}//deleteCarritoCompras
	public CarritoCompras addCarritoCompras(CarritoCompras carritoCompras) {
		lista.add(carritoCompras);
		return carritoCompras;
	}//addCarrito
	public CarritoCompras updateCarritoCompras(long id, String fechaCreacion, Integer cantidadProducto,
			Double precioTotal) {
		CarritoCompras car = null;
		for (CarritoCompras carritoCompras : lista) {
			if(id == carritoCompras.getId()) {
				if(fechaCreacion != null) carritoCompras.setFechaCreacion(fechaCreacion);
				if(cantidadProducto != null) carritoCompras.setCantidadProducto(cantidadProducto);
				if(precioTotal != null) carritoCompras.setPrecioTotal(precioTotal);
				car=carritoCompras;
				break;
			}//if
		}//foreach
		return car;
	}
	
}
