package com.dongweihang.sell.service.impl;

import com.dongweihang.sell.dataobject.OrderDetail;
import com.dongweihang.sell.dataobject.OrderMaster;
import com.dongweihang.sell.dto.CartDTO;
import com.dongweihang.sell.dto.OrderDTO;
import com.dongweihang.sell.enums.OrderStatusEnum;
import com.dongweihang.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImplTest.class);

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("ddddddddddd");
        orderDTO.setBuyerAddress("杭州");
        orderDTO.setBuyerPhone("13808076185");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(1);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        logger.info("【创建订单】 result={}", result);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
//        OrderDTO orderDTO = orderService.findOne("1517325871468165760");
//        logger.info("find order by id : {}", orderDTO);
//        assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
//        PageRequest request = new PageRequest(0,2);
//        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);
//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
//        OrderDTO orderDTO = orderService.findOne("1517325871468165760");
//        OrderDTO result = orderService.cancel(orderDTO);
//        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void finish() {
//        OrderDTO orderDTO = orderService.findOne("1517325871468165760");
//        OrderDTO result = orderService.finish(orderDTO);
//        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1517325871468165760");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),orderDTO.getPayStatus());
    }
}