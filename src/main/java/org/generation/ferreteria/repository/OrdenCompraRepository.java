package org.generation.ferreteria.repository;

import java.util.Optional;

import org.generation.ferreteria.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long>{
	Optional<OrdenCompra> findByFechaOrden(String fechaOrden);
}
