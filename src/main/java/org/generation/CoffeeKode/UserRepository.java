package org.generation.CoffeeKode;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; //importamos cositas del JPA
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long> { // Extendemos de JPA para crear nuestras tablitas

	@Query("SELECT u FROM User u WHERE u.username=?1") //Consultas de JPA integradas
	Optional<User> findByUsername(String username); //Consulta Optional creada por Felipe

	//Por importar @Query, Optional
	
}

