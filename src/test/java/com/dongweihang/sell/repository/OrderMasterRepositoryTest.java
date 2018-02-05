package com.dongweihang.sell.repository;

import com.dongweihang.sell.dataobject.OrderMaster;
import com.dongweihang.sell.enums.OrderStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    @Transactional
    public void insertTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1");
        orderMaster.setBuyerName("okok");
        orderMaster.setBuyerPhone("123123123");
        orderMaster.setBuyerAddress("123edwe12e12e");
        orderMaster.setBuyerOpenid("123123");
        orderMaster.setOrderAmount(new BigDecimal(8.9));

        repository.save(orderMaster);

        Assert.assertNotEquals(null,repository.findOne("1"));
    }

    @Test
    @Transactional
    public void updateTest() {

        OrderMaster orderM = new OrderMaster();
        orderM.setOrderId("1");
        orderM.setBuyerName("okok");
        orderM.setBuyerPhone("123123123");
        orderM.setBuyerAddress("123edwe12e12e");
        orderM.setBuyerOpenid("123123");
        orderM.setOrderAmount(new BigDecimal(8.9));

        repository.save(orderM);

        OrderMaster orderMaster = repository.findOne("1");
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        repository.save(orderMaster);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),repository.findOne("1").getOrderStatus());

    }

    @Test
    @Transactional
    public void findOneTest() {
        OrderMaster orderM = new OrderMaster();
        orderM.setOrderId("1");
        orderM.setBuyerName("okok");
        orderM.setBuyerPhone("123123123");
        orderM.setBuyerAddress("123edwe12e12e");
        orderM.setBuyerOpenid("123123");
        orderM.setOrderAmount(new BigDecimal(8.9));

        repository.save(orderM);

        assertNotEquals(null,repository.findOne("1"));
    }

    @Test
    @Transactional
    public void findAllTest() {
        OrderMaster orderM = new OrderMaster();
        orderM.setOrderId("1");
        orderM.setBuyerName("okok");
        orderM.setBuyerPhone("123123123");
        orderM.setBuyerAddress("123edwe12e12e");
        orderM.setBuyerOpenid("123123");
        orderM.setOrderAmount(new BigDecimal(8.9));

        repository.save(orderM);

        Assert.assertNotEquals(0,repository.findAll().size());
    }

    @Test
    @Transactional
    public void deleteTest() {
        OrderMaster orderM = new OrderMaster();
        orderM.setOrderId("1");
        orderM.setBuyerName("okok");
        orderM.setBuyerPhone("123123123");
        orderM.setBuyerAddress("123edwe12e12e");
        orderM.setBuyerOpenid("123123");
        orderM.setOrderAmount(new BigDecimal(8.9));

        repository.save(orderM);

        repository.delete("1");
        Assert.assertEquals(null,repository.findOne("1"));
    }

    @Test
    @Transactional
    public void findByBuyerOpenidTest(){
        OrderMaster orderM = new OrderMaster();
        orderM.setOrderId("1");
        orderM.setBuyerName("okok");
        orderM.setBuyerPhone("123123123");
        orderM.setBuyerAddress("123edwe12e12e");
        orderM.setBuyerOpenid("123123");
        orderM.setOrderAmount(new BigDecimal(8.9));
        repository.save(orderM);

        PageRequest request = new PageRequest(0,1);

        Page<OrderMaster> result = repository.findByBuyerOpenid("123123",request);

        Assert.assertNotEquals(0,result.getTotalElements());
    }

}
