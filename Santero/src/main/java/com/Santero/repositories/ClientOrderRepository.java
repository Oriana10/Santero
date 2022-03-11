package com.Santero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santero.entities.ClientOrder;

@Repository
/**
 * @author Lamberti
 */
public interface ClientOrderRepository extends JpaRepository<ClientOrder, String>{

}
