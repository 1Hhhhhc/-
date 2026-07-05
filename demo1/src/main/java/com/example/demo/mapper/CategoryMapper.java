package com.example.demo.mapper;

import com.example.demo.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category")
    List<Category> findAll();

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category findById(Integer id);
}