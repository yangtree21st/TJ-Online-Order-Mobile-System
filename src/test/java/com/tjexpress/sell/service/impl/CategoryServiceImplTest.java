package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {


    @Autowired
    private CategoryServiceImpl categoryServiceIml;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryServiceIml.findOne(2);

        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryIn() {
    }

    @Test
    public void save() {
    }
}