package com.jacek.projekt.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findProductByName(String product_name) {
        return productRepository.findByProductName(product_name);
    }

    @Override
    public void saveProduct(Product product) {
        /*product = productRepository.findProductName("");*/
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

}
