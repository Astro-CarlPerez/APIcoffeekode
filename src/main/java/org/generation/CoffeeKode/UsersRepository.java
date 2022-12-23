package org.generation.CoffeeKode;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; //importamos cositas del JPA
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository <Users, Long> { // Extendemos de JPA para crear nuestras tablitas

	@Query("SELECT u FROM Users u WHERE u.username=?1") //Consultas de JPA integradas
	Optional<Users> findByUsername(String username); //Consulta Optional creada por Felipe

	//Por importar @Query, Optional
	
}
