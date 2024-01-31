package com.java.learning.reactiveprogramming.controller;

import com.java.learning.reactiveprogramming.dao.Customer;
import com.java.learning.reactiveprogramming.dto.ProductDto;
import com.java.learning.reactiveprogramming.service.CustomerService;
import com.java.learning.reactiveprogramming.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/getAll")
    Flux<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/get/{id}")
    Mono<ProductDto> getProduct(Integer id){
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    Mono<ProductDto> createProduct(ProductDto productDto){
        return productService.createProduct(Mono.just(productDto));
    }




}

