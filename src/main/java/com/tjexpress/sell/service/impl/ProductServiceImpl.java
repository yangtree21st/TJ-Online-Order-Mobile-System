package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.dataobject.ProductInfo;
import com.tjexpress.sell.dto.CartDTO;
import com.tjexpress.sell.enums.ProductStatusEnum;
import com.tjexpress.sell.repository.ProductInfoRepository;
import com.tjexpress.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStorage(List<CartDTO> cartDTOList) {

    }

    @Override
    public void deduckStorage(List<CartDTO> cartDTOList) {

    }
}
