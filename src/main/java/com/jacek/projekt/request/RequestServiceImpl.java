package com.jacek.projekt.request;

import com.jacek.projekt.product.Product;
import com.jacek.projekt.product.ProductRepository;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service("requestService")
@Transactional
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    @Override
    public void saveRequest(Request request, Store storeName, Product productName) {

        String storeName2 = storeName.toString();

        String productName2 = productName.toString();

        Store store = storeRepository.findStoreByName(storeName2);
        request.setStores(new HashSet<Store>(Arrays.asList(store)));

        Product product = productRepository.findProductByName(productName2);
        request.setProducts(new HashSet<Product>(Arrays.asList(product)));

        requestRepository.save(request);
    }
}