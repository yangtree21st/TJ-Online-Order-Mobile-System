package com.tjexpress.sell.repository;

import com.tjexpress.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository repository;

    private final String OPENID = "15";

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId("12");
        orderMaster.setBuyerName("Francis");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("TJexpress");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}