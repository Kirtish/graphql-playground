package com.example.graphql.controllers;

import com.example.graphql.pojo.AgeRangeFilter;
import com.example.graphql.pojo.Customer;
import com.example.graphql.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping(name = "customers")
    public Flux<Customer> getAllCustomers(){
    return  customerService.getCustomers();
    }

    @QueryMapping(name = "customerById")
    public Mono<Customer> getCustomerById(@Argument int id){
        return  customerService.getCustomerById(id);
    }
    @QueryMapping(name = "customerNameContans")
    public Flux<Customer> getCustomerNameContains(@Argument String name){
        return  customerService.getCustomerWithNameContains(name);
    }
    @QueryMapping(name="customerByAgeRange")
    public Flux<Customer> getCustomWithinAgeRange(@Argument Integer minAge, @Argument Integer maxAge){
        return customerService.getCustomWithinAgeRange(minAge,maxAge);
    }

    @QueryMapping(name = "customerByAgeRangeFilter")
    public Flux<Customer> getCustomWithinAgeRangeFilter(@Argument AgeRangeFilter filter){
        return customerService.getCustomWithinAgeRange(filter);
    }
}
