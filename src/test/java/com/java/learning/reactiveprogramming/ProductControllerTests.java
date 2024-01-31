package com.java.learning.reactiveprogramming;

import com.java.learning.reactiveprogramming.controller.ProductController;
import com.java.learning.reactiveprogramming.dto.ProductDto;
import com.java.learning.reactiveprogramming.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(ProductController.class)
public class ProductControllerTests {

    @Autowired
    private WebTestClient webTestClient;


    @MockBean
    private ProductService productService;

    @Test
    public void testCreateProduct(){
        ProductDto productDto = new ProductDto(1,"HondaCbr350",(long) 3,(long) 300000);

        Mockito.when(productService.createProduct(Mono.just(productDto))).thenReturn(Mono.just(productDto));



        webTestClient.post()
                .uri("/product/create")
                .body(Mono.just(productDto),ProductDto.class)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .equals(productDto);


    }







}
