package com.tjexpress.sell.VO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tjexpress.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryname;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("product")
    private List<ProductInfoVO> productInfoVOList ;
}
