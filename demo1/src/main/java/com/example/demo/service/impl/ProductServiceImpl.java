package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public PageInfo<Product> findPage(Integer pageNum, Integer pageSize,
                                      Integer catId, String keyword,
                                      Double minPrice, Double maxPrice) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> list = productMapper.findWithConditions(catId, keyword, minPrice, maxPrice);
        return new PageInfo<>(list);
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findByIdWithCategory(id);
    }
}