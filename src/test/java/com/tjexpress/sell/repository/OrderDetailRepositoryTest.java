package com.tjexpress.sell.repository;

import com.tjexpress.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.soap.Detail;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {



    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("00000001");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("www.test.com");
        orderDetail.setProductId("1234567");
        orderDetail.setProductName("bicycle");
        orderDetail.setProductPrice(BigDecimal.valueOf(200));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByOrderId() {
          List<OrderDetail>result =orderDetailRepository.findByOrderId("123456");
          System.out.println(result);
          Assert.assertNotEquals(null,result);
    }
}