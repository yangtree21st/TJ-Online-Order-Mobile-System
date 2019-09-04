package com.tjexpress.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST( 10, "The product do not exist!"),
    INVENTORY_NOT_ENOUGH (11,"The inventory is not enough"),
    ORDER_NOT_EXIST(12,"Order is not exist"),
    ORDERDETAIL_NOT_EXIST(13,"Order detail is not exist"),
    ;

    private Integer code;

    private String message;

    ResultEnum ( Integer code, String message){
        this.code= code;
        this.message = message;
    }


}
