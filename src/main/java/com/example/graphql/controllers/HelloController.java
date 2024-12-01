package com.example.graphql.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class HelloController {

    @QueryMapping
    public String sayHello(){
        return "Hello World!";
    }

    @QueryMapping
    public Mono<String> sayHelloTo(@Argument String name){
        return Mono.justOrEmpty("Hello "+name);
    }
}
