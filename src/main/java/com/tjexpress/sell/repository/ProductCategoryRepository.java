package com.tjexpress.sell.repository;


import com.tjexpress.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

        List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    }


