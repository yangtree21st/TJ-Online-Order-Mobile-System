package com.tjexpress.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    WAIT(0,"wait to pay"),
    SUCESS(1," Successfully to pay ");


    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }



}
