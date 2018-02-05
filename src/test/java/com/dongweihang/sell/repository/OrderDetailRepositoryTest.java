package com.dongweihang.sell.repository;

import com.dongweihang.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    @Transactional
    public void insertTest() {
        OrderDetail orderDetail = insertOneDetail("123123");
        repository.save(orderDetail);

        Assert.assertNotEquals(null,repository.findOne("123123"));

    }

    @Test
    @Transactional
    public void updateTest() {
        OrderDetail orderDetail = insertOneDetail("123123");
        repository.save(orderDetail);

        OrderDetail detail = repository.findOne("123123");
        detail.setProductName("kk");
        repository.save(detail);

        Assert.assertEquals("kk",repository.findOne("123123").getProductName());
    }

    @Test
    @Transactional
    public void findOneTest() {
        OrderDetail orderDetail = insertOneDetail("123123");
        repository.save(orderDetail);

        Assert.assertNotEquals(null,repository.findOne("123123"));

    }

    @Test
    @Transactional
    public void deleteTest() {
        OrderDetail orderDetail = insertOneDetail("123123");
        repository.save(orderDetail);
        repository.delete("123123");

        Assert.assertEquals(null,repository.findOne("123123"));

    }

    @Test
    @Transactional
    public void findAllTest() {
        OrderDetail orderDetail = insertOneDetail("123123");
        repository.save(orderDetail);

        Assert.assertNotEquals(null,repository.findAll());
    }


    @Test
    @Transactional
    public void findByOrderIdTest() {
        OrderDetail orderDetail = insertOneDetail("123123");
        repository.save(orderDetail);

        Assert.assertNotEquals(null,repository.findByOrderId("111"));
    }

    public static OrderDetail insertOneDetail(String detailId){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(detailId);
        orderDetail.setOrderId("111");
        orderDetail.setProductIcon("https://xxxx.jpg");
        orderDetail.setProductId("123123");
        orderDetail.setProductName("pidan");
        orderDetail.setProductPrice(new BigDecimal(2.1));
        orderDetail.setProductQuantity(12);

        return orderDetail;
    }
}