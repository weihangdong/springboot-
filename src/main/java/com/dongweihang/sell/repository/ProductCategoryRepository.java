package com.dongweihang.sell.repository;

import com.dongweihang.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    ProductCategory findByCategoryType(Integer i);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
