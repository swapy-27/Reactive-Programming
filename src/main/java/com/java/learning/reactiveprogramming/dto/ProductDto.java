package com.java.learning.reactiveprogramming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    @Id
    private Integer id;
    private String name;

    private Long qty;

    private Long price;





}
