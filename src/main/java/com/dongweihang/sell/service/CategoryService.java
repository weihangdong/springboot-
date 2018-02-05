package com.dongweihang.sell.service;

import com.dongweihang.sell.dataobject.ProductCategory;
import com.dongweihang.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
