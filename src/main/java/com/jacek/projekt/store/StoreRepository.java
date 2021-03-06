package com.jacek.projekt.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("storeRepository")
public interface StoreRepository extends JpaRepository<Store, Integer> {

    Store findStoreByName(String name);

    Store findStoreById(int id);

}
