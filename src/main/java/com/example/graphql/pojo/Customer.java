package com.example.graphql.pojo;

import lombok.*;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class Customer {

    int id;
    String name;
    int age;
    String city;


}
