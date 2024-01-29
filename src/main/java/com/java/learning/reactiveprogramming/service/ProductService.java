package com.java.learning.reactiveprogramming.service;

import com.java.learning.reactiveprogramming.dto.ProductDto;
import com.java.learning.reactiveprogramming.repositories.ProductRepository;
import com.java.learning.reactiveprogramming.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    //Crud operations in Reactive Programming


   public  Mono<ProductDto> getProductById(int id){
        return productRepository.findById(id).map(AppUtil::entityToDto);
    }

    public Flux<ProductDto> getAllProducts(){
        return productRepository.findAll().map(e->AppUtil.entityToDto(e));
    }


    public Flux<ProductDto> findAllByRange(long min, long max){
       return productRepository.findByPriceBetween(Range.closed(min,max)).map(AppUtil::entityToDto);
    }
    public Mono<ProductDto> createProduct(Mono<ProductDto> productDtoMono){
        return productDtoMono.map(AppUtil::dtoToEntity)
                .flatMap(productRepository::save)
                .map(AppUtil::entityToDto);
    }







}
