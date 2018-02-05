package com.dongweihang.sell.service.impl;

import com.dongweihang.sell.controller.BuyerOrderController;
import com.dongweihang.sell.dto.OrderDTO;
import com.dongweihang.sell.enums.ResultEnum;
import com.dongweihang.sell.exception.SellException;
import com.dongweihang.sell.service.BuyerService;
import com.dongweihang.sell.service.OrderService;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(BuyerServiceImpl.class);

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid,orderId);
        if(orderDTO == null){
            logger.error("【取消订单】查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是该用户的openid
        if (orderDTO.getBuyerOpenid() != openid) {
            logger.error("【查询订单】订单的openid与用户的openid不一致，openid={}, order's openid={}", openid, orderDTO.getBuyerOpenid());
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
