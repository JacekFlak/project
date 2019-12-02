package com.jacek.projekt.request;

import com.jacek.projekt.product.Product;
import com.jacek.projekt.store.Store;

public interface RequestService {

    void saveRequest(Request request, Store storeName, Product productName);
}
