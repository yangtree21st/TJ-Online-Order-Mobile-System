package com.tjexpress.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;

    /** name. */
    private String productName;

    /** unitPrice. */
    private BigDecimal productPrice;

    /** number of stock. */
    private Integer productStock;

    /** productDescrition. */
    private String productDescription;

    /** productIcon. */
    private String productIcon;

    /** productStatus, 0common 1 unshel. */
    private Integer productStatus;

    /** categoryType. */
    private Integer categoryType;

}
