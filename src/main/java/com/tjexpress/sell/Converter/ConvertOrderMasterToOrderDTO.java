package com.tjexpress.sell.Converter;

import com.tjexpress.sell.dataobject.OrderMaster;
import com.tjexpress.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertOrderMasterToOrderDTO {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> listConvert(List<OrderMaster> orderMasters){
     return    orderMasters.stream()
                 .map(e->convert(e) )
                 .collect(Collectors.toList());
    }
}
