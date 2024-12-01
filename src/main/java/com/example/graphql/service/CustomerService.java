package com.example.graphql.service;

import com.example.graphql.pojo.AgeRangeFilter;
import com.example.graphql.pojo.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final Flux<Customer> customers = Flux.just(
            Customer.create(1, "John" , 25 , "New York"),
            Customer.create(2, "Joe" , 23 , "Atlanta"),
            Customer.create(3, "Albert" , 35 , "New Jersey"),
            Customer.create(4, "Daniel" , 45 , "California")
            );

    public Flux<Customer> getCustomers(){
        return this.customers;
    }

    public Mono<Customer> getCustomerById(int id){
        return customers.filter(customer -> customer.getId()== (id)).next();
    }


    public Flux<Customer> getCustomerWithNameContains(String name){
        return customers.filter(customer -> customer.getName().contains(name));
    }

    public Flux<Customer> getCustomWithinAgeRange(Integer minAge, Integer maxAge) {
        return  customers.filter(customer -> customer.getAge()<= maxAge && customer.getAge()>=minAge);
    }

    public Flux<Customer> getCustomWithinAgeRange(AgeRangeFilter ageRangeFilter) {
        return  customers.filter(customer -> customer.getAge()<= ageRangeFilter.getMaxAge() && customer.getAge()>=ageRangeFilter.getMinAge());
    }
}
