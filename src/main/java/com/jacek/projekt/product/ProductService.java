package com.jacek.projekt.product;

import java.util.List;

public interface ProductService {

    Product findProductByName(String name);

    void saveProduct(Product product);

    List<Product> findAll();
}
