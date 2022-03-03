package com.Santero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Santero.entities.User;

@Repository
/**
 * @author Lamberti
 */
public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User getByEmail(@Param("email") String email);
	
}
