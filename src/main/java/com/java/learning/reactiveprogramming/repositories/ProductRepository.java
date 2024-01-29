package com.java.learning.reactiveprogramming.repositories;

import com.java.learning.reactiveprogramming.dao.Product;
import com.java.learning.reactiveprogramming.dto.ProductDto;
import org.springframework.data.domain.Range;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {


    Mono<Product> findById(int id);

    Flux<Product> findByPriceBetween(Range<Long> closed);
}
