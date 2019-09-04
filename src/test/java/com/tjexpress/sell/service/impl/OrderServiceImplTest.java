package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String OpenId = "15";

    private final String OrderId = "12";

    @Test
    public void create() {
    }

    @Test
    public void findOne() {
       OrderDTO orderDTO = orderService.findOne(OrderId);
       log.info("Search for one order information",orderDTO);
        Assert.assertEquals(OrderId,orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2);

        Page<OrderDTO> orderDTOPage = orderService.findList(OpenId,pageRequest);
        log.info("Search by one user's OpenId to show the order information ordered list ", orderDTOPage );
        Assert.assertNotEquals(null,orderDTOPage);
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}