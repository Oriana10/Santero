package com.Santero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santero.entities.Order;

@Repository
/**
 * @author Lamberti
 */
public interface OrderRepository extends JpaRepository<Order, String>{

}
