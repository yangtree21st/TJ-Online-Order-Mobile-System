package com.tjexpress.sell.dataobject;


import com.tjexpress.sell.enums.OrderStatusEnum;
import com.tjexpress.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderMaster {

    @Id
    private String order_id;

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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** PayStatusEnum, 0 not pay. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** createTime. */
    private Date createTime;

    /** updateTime. */
    private Date updateTime;

}
