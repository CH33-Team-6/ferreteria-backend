package org.generation.ferreteria.repository;

import java.util.Optional;

import org.generation.ferreteria.model.CarritoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoComprasRepository extends JpaRepository<CarritoCompras, Long> {
	Optional<CarritoCompras> findByfechaCreacion(String fechaCreacion);
}
