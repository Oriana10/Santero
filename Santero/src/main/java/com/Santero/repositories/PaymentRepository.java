package com.Santero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santero.entities.Payment;

@Repository
/**
 * @author Nicolas
 */
public interface PaymentRepository extends JpaRepository<Payment, String>{

	
}
