package com.Santero.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Santero.entities.Client;

@Repository
/**
 * @author Lamberti
 */
public interface ClientRepository extends JpaRepository<Client, String>{
	
	@Query("SELECT u FROM Client u WHERE u.email = :email")
	public Client getByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Client u WHERE u.email = :email")
	public Optional<Client> getOptionalByEmail(@Param("email") String email);
	
}
