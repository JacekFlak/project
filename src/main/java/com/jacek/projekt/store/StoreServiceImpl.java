package com.jacek.projekt.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("storeService")
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store findStoreByName(String name) {
        return storeRepository.findStoreByName(name);
    }

    @Override
    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    @Override
    public Store findStoreById(int id) {
        Store store = storeRepository.findStoreById(id);
        return store;
    }

    @Override
    public List<Store> findAll() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    @Override
    public Page<Store> findAll(Pageable pageable) {
        Page<Store> storeList = storeRepository.findAll(pageable);
        return storeList;
    }
}