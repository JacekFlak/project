package com.jacek.projekt.request;

import com.jacek.projekt.product.Product;
import com.jacek.projekt.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RequestService {

    void saveRequest(Request request, Store store, Product product);

    List<Request> findAll();

    Page<Request> findAll(Pageable pageable);
}
