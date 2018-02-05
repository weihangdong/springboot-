package com.dongweihang.sell.repository;

import com.dongweihang.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory category = repository.findOne(1);
        System.out.println(category==null?null:category.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotEquals(null,result);
        System.out.println(result);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = repository.findByCategoryType(3);
        productCategory.setCategoryName("男生最爱");
        repository.save(productCategory);
        System.out.println(repository.findByCategoryType(3));
    }

    @Test
    public void deleteTest(){
        repository.delete(repository.findByCategoryType(3));
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3);

        List<ProductCategory> productCategories = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(null, productCategories.size());
        System.out.println(productCategories);
    }
}