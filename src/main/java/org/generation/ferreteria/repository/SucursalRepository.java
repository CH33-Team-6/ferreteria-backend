package org.generation.ferreteria.repository;

import java.util.Optional;

import org.generation.ferreteria.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long>{
	Optional<Sucursal> findBySucursal (String sucursal);
}//Sucursal Interface{
