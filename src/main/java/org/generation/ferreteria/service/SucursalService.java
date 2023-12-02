package org.generation.ferreteria.service;

import java.util.List;
import java.util.Optional;


import org.generation.ferreteria.model.Sucursal;
import org.generation.ferreteria.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {
	private final SucursalRepository sucursalRepository; 
	@Autowired
	public SucursalService(SucursalRepository sucursalRepository) {
		this.sucursalRepository=sucursalRepository;
	}//constructor
	
	public List <Sucursal> getAllSucursales() {
		return sucursalRepository.findAll();
	}//getAll
	
	public Sucursal getSucursal(long id) {
		return sucursalRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("La sucursal con el id ["
						+ "] no existe"));
	}//getSucursal
	
	public Sucursal deleteSucursal(long id) {
		Sucursal suc = null;
			if(sucursalRepository.existsById(id)) {
				suc=sucursalRepository.findById(id).get();
				sucursalRepository.deleteById(id);;
			}//if
		return suc;
	}//deleteSucursal
	
	public Sucursal addSucursal(Sucursal sucursal) {
		Optional<Sucursal> tmpSuc=sucursalRepository.findBynombreSucursal(sucursal.getNombreSucursal());
		if (tmpSuc.isEmpty()) {
			return sucursalRepository.save(sucursal);
		}//if
		else {
			System.out.println("Ya existe la sucursal con el nombre ["
					+ sucursal.getNombreSucursal()+"]");
			return null;
		}//else
	}//addSucursal
	public Sucursal updateSucursal(long id, String nombreSucursal, String ubicacion, String telefono) {
		Sucursal suc = null;
			if(sucursalRepository.existsById(id)) {
				suc=sucursalRepository.findById(id).get();
				if(nombreSucursal != null) suc.setNombreSucursal(nombreSucursal);
				if(ubicacion != null) suc.setUbicacion(ubicacion);
				if(telefono != null) suc.setTelefono(telefono);
				sucursalRepository.save(suc);
			}//if
		return suc;
	}//updateSucursal
	
	
}
