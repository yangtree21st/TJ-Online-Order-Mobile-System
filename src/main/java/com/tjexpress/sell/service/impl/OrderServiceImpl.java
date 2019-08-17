package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.ResultVOUtil.KeyUtil;
import com.tjexpress.sell.dataobject.OrderDetail;
import com.tjexpress.sell.dataobject.ProductInfo;
import com.tjexpress.sell.dto.OrderDTO;
import com.tjexpress.sell.enums.ResultEnum;
import com.tjexpress.sell.exception.SellException;
import com.tjexpress.sell.repository.OrderDetailRepository;
import com.tjexpress.sell.service.OrderService;
import com.tjexpress.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
     private OrderDetailRepository orderDetailRepository;



    BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniquekey();

        //1.find the product information (number fo store, price of unit)
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
         if (productInfo == null ){
             throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
         }
            // check whether enough of the number of stock
            // 2.caculate the amount of an order

            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //3.input the order detail information to the database(Ordermaster and OrderDetail

            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniquekey());

            orderDetailRepository.save(orderDetail);

        }


        //2.caculate the amount of the order
        //3.input the information to the database(Ordermaster and OrderDetail)
        //4.deduck the storage;


        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
