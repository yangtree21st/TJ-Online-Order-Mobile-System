package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.dataobject.ProductCategory;
import com.tjexpress.sell.repository.ProductCategoryRepository;
import com.tjexpress.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
  Created by Yang Shu

 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryIn(List<Integer> categoryTypeIdList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeIdList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
