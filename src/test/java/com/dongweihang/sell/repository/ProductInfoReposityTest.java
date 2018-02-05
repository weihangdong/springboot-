package com.dongweihang.sell.repository;

import com.dongweihang.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoReposityTest {

    @Autowired
    private ProductInfoReposity reposity;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductIcon("********8");
        productInfo.setProductDescription("美味的皮蛋粥");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo result = reposity.save(productInfo);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = reposity.findByProductStatus(0);
        Assert.assertNotEquals(null,list);
        Assert.assertNotEquals(0,list.size());
    }
}