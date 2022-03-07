package com.Santero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santero.entities.Delivery;


@Repository
/**
 * @author Nicolas
 */
public interface DeliveryRepository extends JpaRepository<Delivery, String> {

}
