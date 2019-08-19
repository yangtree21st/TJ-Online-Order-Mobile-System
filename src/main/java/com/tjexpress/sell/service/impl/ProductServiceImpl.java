package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.dataobject.ProductInfo;
import com.tjexpress.sell.dto.CartDTO;
import com.tjexpress.sell.enums.ProductStatusEnum;
import com.tjexpress.sell.enums.ResultEnum;
import com.tjexpress.sell.exception.SellException;
import com.tjexpress.sell.repository.ProductInfoRepository;
import com.tjexpress.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void deduckStorage(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {

            // check is this product in the cart exist.
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId()) ;

                if (productInfo == null) {
                    throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
                }

                // check is this product enough to sell

                int result = productInfo.getProductStock() - cartDTO.getProductQuantity();
                if (result < 0) {
                    throw new SellException(ResultEnum.INVENTORY_NOT_ENOUGH);
                }

                // save the result number to repository
                productInfo.setProductStock(result);
                repository.save(productInfo);
            }
        }
    }

