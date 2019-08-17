package com.tjexpress.sell.service;

import com.tjexpress.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /** create. */
    OrderDTO create(OrderDTO orderDTO);

    /** findone. */
    OrderDTO findOne(String orderId);

    /** findorderList. */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** cancel order. */
    OrderDTO cancel(OrderDTO orderDTO);

    /** finish order. */
    OrderDTO finish(OrderDTO orderDTO);

    /** paid. */
    OrderDTO paid(OrderDTO orderDTO);
}
