package com.jacek.projekt.store;

public interface StoreService {

    Store findStoreByName(String name);

    void saveStore(Store store);
}
