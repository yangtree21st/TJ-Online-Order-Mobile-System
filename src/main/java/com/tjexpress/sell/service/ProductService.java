package com.tjexpress.sell.service;

import com.tjexpress.sell.dataobject.ProductInfo;
import com.tjexpress.sell.dto.CartDTO;
import com.tjexpress.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();// the products on the shelves

    Page <ProductInfo> findAll(Pageable pageable);

    ProductInfo save ( ProductInfo productInfo);

    // add inventory
    void increaseStorage(List<CartDTO> cartDTOList);

    // minus inventory
    void deduckStorage(List<CartDTO> cartDTOList);
}
