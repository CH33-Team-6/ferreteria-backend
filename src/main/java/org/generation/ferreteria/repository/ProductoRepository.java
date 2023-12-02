package org.generation.ferreteria.repository;

import java.util.Optional;

import org.generation.ferreteria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>  {
	Optional<Producto> findByNombre(String nombre);
}//interface de producto
