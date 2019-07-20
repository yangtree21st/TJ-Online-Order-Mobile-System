package com.tjexpress.sell.service;

import com.tjexpress.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();// the products on the shelves

    Page <ProductInfo> findAll(Pageable pageable);

    ProductInfo save ( ProductInfo productInfo);

    // add inventory


    // minus inventory

}
