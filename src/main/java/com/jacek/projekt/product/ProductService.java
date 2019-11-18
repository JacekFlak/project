package com.jacek.projekt.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Product findProductByName(String name);

    Product findProductById(int id);

    void saveProduct(Product product);

    List<Product> findAll();
}
