package org.generation.ferreteria.repository;

import java.util.Optional;

import org.generation.ferreteria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Optional<Categoria> findBynCategoria(String nCategoria); 
}//categoria interface
