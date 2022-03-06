package com.Santero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Santero.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query("SELECT p FROM Product p WHERE p.productCategory LIKE :q ORDER BY p.productName")
	List<Product> getByCategory(@Param("q") String q);
	
	@Query("SELECT p FROM Product p WHERE p.productPrice LIKE :q ORDER BY p.productName")
	List<Product> getByPrice(@Param("q") String q);
	
	@Query("SELECT p FROM Product p ORDER BY p.productPrice")
	List<Product> getByPriceASC();
	
	@Query("SELECT p FROM Product p ORDER BY p.productPrice desc")
	List<Product> getByPriceDESC();
	
	@Query("SELECT p FROM Product p WHERE p.productName LIKE :q ORDER BY p.productName")
	List<Product> getByName(@Param("q") String q);
}
