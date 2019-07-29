package com.tjexpress.sell.enums;


import lombok.Getter;

@Getter
public enum OrderStatusEnum {


    NEW(0," new order"),
    FINISHED(1,"finished order"),
    CANCEL(2,"canceled order");

     private Integer code ;

     private String mes;

     OrderStatusEnum(Integer code,String mes){
         this.code = code ;
         this.mes = mes;
     }


}
