package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT p.*, c.name as categoryName " +
            "FROM product p " +
            "LEFT JOIN category c ON p.cat_id = c.id")
    List<Product> findAllWithCategory();

    @Select("SELECT p.*, c.name as categoryName " +
            "FROM product p " +
            "LEFT JOIN category c ON p.cat_id = c.id " +
            "WHERE p.id = #{id}")
    Product findByIdWithCategory(@Param("id") Integer id);

    @Select("<script>" +
            "SELECT p.*, c.name as categoryName " +
            "FROM product p " +
            "LEFT JOIN category c ON p.cat_id = c.id " +
            "<where>" +
            "  <if test='catId != null and catId != \"\"'>" +
            "    AND p.cat_id = #{catId}" +
            "  </if>" +
            "  <if test='keyword != null and keyword != \"\"'>" +
            "    AND p.name LIKE CONCAT('%', #{keyword}, '%')" +
            "  </if>" +
            "  <if test='minPrice != null and minPrice != \"\"'>" +
            "    AND p.price &gt;= #{minPrice}" +
            "  </if>" +
            "  <if test='maxPrice != null and maxPrice != \"\"'>" +
            "    AND p.price &lt;= #{maxPrice}" +
            "  </if>" +
            "</where>" +
            "ORDER BY p.id DESC" +
            "</script>")
    List<Product> findWithConditions(@Param("catId") Integer catId,
                                     @Param("keyword") String keyword,
                                     @Param("minPrice") Double minPrice,
                                     @Param("maxPrice") Double maxPrice);
}