package com.tjexpress.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    UP(0,"on shelves"),DOWN(1,"unshelve");


    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
