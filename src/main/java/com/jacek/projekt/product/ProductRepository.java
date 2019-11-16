package com.jacek.projekt.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductName(String product_name);

}

