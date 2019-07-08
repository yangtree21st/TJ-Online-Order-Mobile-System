package com.tjexpress.sell.dataobject;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    /** categoryName. */
    private String categoryName;

    /** categoryType. */
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
