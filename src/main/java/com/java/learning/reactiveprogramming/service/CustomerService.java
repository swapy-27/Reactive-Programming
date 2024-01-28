package com.java.learning.reactiveprogramming.service;

import com.java.learning.reactiveprogramming.dao.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService {

    private void goToSleep(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Customer> getCustomers() {
        return IntStream.range(0, 50)
                .peek(this::goToSleep)
                .peek(i-> System.out.println("processing count "+ i))
                .mapToObj(i -> new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersAsync() {
        return Flux.range(0, 10)
                .doOnNext(this::goToSleep)
                .doOnNext(i-> System.out.println("processing count "+ i))
                .map(i -> new Customer(i, "customer" + i));

    }


}
