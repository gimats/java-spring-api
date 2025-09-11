package com.leco.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leco.api_crud.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value= "SELECT * FROM product_inventory WHERE product_name =  ?1", nativeQuery = true)
    List<Product> getProdutsByName(String productName);
}