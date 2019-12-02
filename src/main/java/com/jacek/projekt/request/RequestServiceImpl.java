package com.jacek.projekt.request;

import com.jacek.projekt.product.Product;
import com.jacek.projekt.product.ProductRepository;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("requestService")
@Transactional
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    @Override
    public void saveRequest(Request request, Store store, Product product) {
        request.setStore(store);
        request.setProduct(product);
        requestRepository.save(request);
    }

    @Override
    public List<Request> findAll() {
        List<Request> requestList = requestRepository.findAll();
        return requestList;
    }

    @Override
    public Page<Request> findAll(Pageable pageable) {
        Page<Request> requestList = requestRepository.findAll(pageable);
        return requestList;
    }

}