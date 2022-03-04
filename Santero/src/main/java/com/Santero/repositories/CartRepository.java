package com.Santero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Santero.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, String>{

}
