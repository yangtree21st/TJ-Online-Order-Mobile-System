package com.tjexpress.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

public class Productinfo {
    @Entity
    @Data
    public class ProductInfo {

        @Id
        private String productId;

        /**
         * name.
         */
        private String productName;

        /**
         * price of one item.
         */
        private BigDecimal productPrice;

        /**
         * the number of productstock.
         */
        private Integer productStock;

        /**
         * productDescription.
         */
        private String productDescription;

        /**
         * productIcon.
         */
        private String productIcon;

        /**
         * productStatus, 0common 1off the shelf.
         */
        private Integer productStatus;

        /**
         * the categoryType.
         */
        private Integer categoryType;

    }
}


