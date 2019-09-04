package com.tjexpress.sell.service.impl;

import com.tjexpress.sell.Converter.ConvertOrderMasterToOrderDTO;
import com.tjexpress.sell.ResultVOUtil.KeyUtil;
import com.tjexpress.sell.dataobject.OrderDetail;
import com.tjexpress.sell.dataobject.OrderMaster;
import com.tjexpress.sell.dataobject.ProductInfo;
import com.tjexpress.sell.dto.CartDTO;
import com.tjexpress.sell.dto.OrderDTO;
import com.tjexpress.sell.enums.ResultEnum;
import com.tjexpress.sell.exception.SellException;
import com.tjexpress.sell.repository.OrderDetailRepository;
import com.tjexpress.sell.repository.OrderMasterRepository;
import com.tjexpress.sell.service.OrderService;
import com.tjexpress.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
     private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

    @Override
    @Transactional
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
            BeanUtils.copyProperties(productInfo,orderDetail);

            orderDetailRepository.save(orderDetail);

        }



        //3.input the information to the database(Ordermaster)
            OrderMaster orderMaster = new OrderMaster();
            orderMaster.setOrderId(orderId);
            orderMaster.setOrderAmount(orderAmount);
            orderMasterRepository.save(orderMaster);

        //4.deduck the storage;
            List<CartDTO> cartDTOlist = orderDTO.getOrderDetailList()
                    .stream().map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                    .collect(Collectors.toList());
            productService.deduckStorage(cartDTOlist);


        return orderDTO ;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster =orderMasterRepository.findOne(orderId);
        if(orderMaster == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetaillist = orderDetailRepository.findByOrderId(orderId);
        if(orderDetaillist ==null){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetaillist);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> resultPage =orderMasterRepository.findByBuyerOpenid(buyerOpenid,pageable);
        List<OrderDTO> DTOlistResult = ConvertOrderMasterToOrderDTO.listConvert(resultPage.getContent());

        return new PageImpl<OrderDTO>(DTOlistResult,pageable,resultPage.getTotalElements());
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
