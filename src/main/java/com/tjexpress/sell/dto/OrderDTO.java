package com.tjexpress.sell.dto;


import com.tjexpress.sell.dataobject.OrderDetail;
import com.tjexpress.sell.enums.OrderStatusEnum;
import com.tjexpress.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {


    private String orderId;



    /** buyerName. */
    private String buyerName;

    /** buyerPhone. */
    private String buyerPhone;

    /** buyerAddress. */
    private String buyerAddress;

    /** buyerOpenid. */
    private String buyerOpenid;

    /** orderAmount. */
    private BigDecimal orderAmount;

    /** OrderStatusEnum, default 0 new order. */
    private Integer orderStatus ;

    /** PayStatusEnum, 0 not pay. */
    private Integer payStatus ;

    /** createTime. */
    private Date createTime;

    /** updateTime. */
    private Date updateTime;

    List<OrderDetail> orderDetailList ;
}
