package com.jacek.projekt.store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreService {

    Page<Store> findAll(Pageable pageable);

    Store findStoreByName(String name);

    Store findStoreById(int id);

    void saveStore(Store store);

    List<Store> findAll();
}
