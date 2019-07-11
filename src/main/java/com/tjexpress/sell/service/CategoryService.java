package com.tjexpress.sell.service;

import com.tjexpress.sell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryIn(List<Integer> categoryTypeIdList);

    ProductCategory save(ProductCategory productCategory);

}
