package com.jacek.projekt.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("storeService")
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store findStoreByName(String name) {
        return storeRepository.findByName(name);
    }

    @Override
    public void saveStore(Store store) {
        storeRepository.save(store);
    }

}