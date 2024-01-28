package com.java.learning.reactiveprogramming.controller;

import com.java.learning.reactiveprogramming.dao.Customer;
import com.java.learning.reactiveprogramming.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/sync")
    List<Customer> getCustomersSync(){
        return  customerService.getCustomers();
    }

    @GetMapping(value = "/async",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Customer> getCustomersAsync(){
        return  customerService.getCustomersAsync();
    }



}
