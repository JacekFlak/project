package com.jacek.projekt.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        //product = productRepository.findProductName("");
        productRepository.save(product);
    }

    @Override
    public Product findProductById(int id) {
        Product product = productRepository.findProductById(id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<Product> productList = productRepository.findAll(pageable);
        return productList;
    }
}
