package org.generation.ferreteria.service;

import java.util.ArrayList;

import org.generation.ferreteria.model.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {
	public final ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
	@Autowired
	public SucursalService() {
		lista.add(new Sucursal("San Antonio", "San Antonio 503, Juarez, Nuevo Leon", "8130391674"));
		lista.add(new Sucursal("Higeras", "Higueras 100, Residencial Los Huertos, 67265 Cdad. Benito Juárez, Nuevo Leon", "8115565307"));
	}//constructor
	public ArrayList<Sucursal> getAllSucursales() {
		// TODO Auto-generated method stub
		return lista;
	}
	public Sucursal getSucursal(long id) {
		Sucursal suc = null;
		for (Sucursal sucursal : lista) {
			if(id == sucursal.getId()) {
				suc=sucursal;
				break;
			}//if
		}//foreach
		return suc;
	}//getONEservice
	public Sucursal deleteSucursal(long id) {
		Sucursal suc = null;
		for (Sucursal sucursal : lista) {
			if(id == sucursal.getId()) {
				suc=sucursal;
				lista.remove(sucursal);
				break;
			}//if
		}//foreach
		return suc;
	}
	public Sucursal addSucursal(Sucursal sucursal) {
		lista.add(sucursal);
		return sucursal;
	}
	public Sucursal updateSucursal(long id, String nombreSucursal, String ubicacion, String telefono) {
		Sucursal suc = null;
		for (Sucursal sucursal : lista) {
			if(id == sucursal.getId()) {
				if(nombreSucursal != null) sucursal.setNombreSucursal(nombreSucursal);
				if(ubicacion != null) sucursal.setUbicacion(ubicacion);
				if(telefono != null) sucursal.setTelefono(telefono);
				suc=sucursal;
				break;
			}//if
		}//foreach
		return suc;
	}//updateSucursal
	
	
	
}
