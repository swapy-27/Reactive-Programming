package com.java.learning.reactiveprogramming.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "products")
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;
    private String name;
    private Long qty;
    private Long price;

}
