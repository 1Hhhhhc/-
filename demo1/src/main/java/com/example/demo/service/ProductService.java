package com.example.demo.service;

import com.example.demo.entity.Product;
import com.github.pagehelper.PageInfo;

public interface ProductService {

    PageInfo<Product> findPage(Integer pageNum, Integer pageSize,
                               Integer catId, String keyword,
                               Double minPrice, Double maxPrice);

    Product findById(Integer id);
}