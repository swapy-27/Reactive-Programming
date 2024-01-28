package com.java.learning.reactiveprogramming.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int id;
    private String name;

}
