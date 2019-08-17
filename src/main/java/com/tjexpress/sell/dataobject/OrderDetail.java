package com.tjexpress.sell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** orderid. */
    private String orderId;

    /** productid. */
    private String productId;

    /** productName. */
    private String productName;

    /** productPrice. */
    private BigDecimal productPrice;

    /** productQuantity. */
    private Integer productQuantity;

    /** productIcon. */
    private String productIcon;
}

