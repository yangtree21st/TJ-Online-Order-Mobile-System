package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {


    @Autowired
    private CategoryServiceImpl categoryServiceIml;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryServiceIml.findOne(2);

        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = categoryServiceIml.findAll();

        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryIn() throws Exception {
        List<ProductCategory> list = categoryServiceIml.findByCategoryIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,list);
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory(" test category",11);
        ProductCategory result = categoryServiceIml.save(productCategory);
        Assert.assertEquals(result,productCategory);
    }
}