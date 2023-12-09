package org.generation.ferreteria.service;

import java.util.List;
import java.util.Optional;

import org.generation.ferreteria.model.CarritoCompras;
import org.generation.ferreteria.repository.CarritoComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CarritoComprasService {
	private final CarritoComprasRepository carritoComprasRepository;
	@Autowired
	public CarritoComprasService(CarritoComprasRepository carritoComprasRepository) {
		this.carritoComprasRepository=carritoComprasRepository;
	}//constructor
	public List<CarritoCompras> getAllCarritoCompras() {
		return carritoComprasRepository.findAll();
	}//metodo getAll
	public CarritoCompras getCarritoCompras(long id) {
		return carritoComprasRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El carrito de compras con el id ["
						+ "] no existe"));
	}//getCarritoCompras
	
	public CarritoCompras deleteCarritoCompras(long id) {
		CarritoCompras car = null;
		if(carritoComprasRepository.existsById(id)) {
			car=carritoComprasRepository.findById(id).get();
			carritoComprasRepository.deleteById(id);
		}//if
	return car;
	}//deleteCarritoCompras
	public CarritoCompras addCarritoCompras(CarritoCompras carritoCompras) {
		Optional<CarritoCompras> tmpCar= carritoComprasRepository.findByfecha(carritoCompras.getFecha());
		if (tmpCar.isEmpty()) {
			return carritoComprasRepository.save(carritoCompras);
		}//if
		else {
			System.out.println("Ya existe el carrito de compras con la fechaCreacion ["
					+ carritoCompras.getFecha() +"]");
			return null;
		}//else
	}//addCarrito
	public CarritoCompras updateCarritoCompras(long id, String fecha, Integer cantidad,
			Double precio) {
		CarritoCompras car = null;
			if(carritoComprasRepository.existsById(id)) {
				car=carritoComprasRepository.findById(id).get();
				if(fecha != null) car.setFecha(fecha);
				if(cantidad != null) car.setCantidad(cantidad);
				if(precio != null) car.setPrecio(precio);
				carritoComprasRepository.save(car);
			}//if
		return car;
	}//updateCarritoCompras
	
}
