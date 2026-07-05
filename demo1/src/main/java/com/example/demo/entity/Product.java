package com.example.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Product {
    private Integer id;
    private String name;
    private String photoUrl;
    private Double price;
    private String descp;
    private Date releaseDate;
    private Integer catId;
    private String categoryName;
}