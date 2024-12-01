package com.example.graphql.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgeRangeFilter implements Serializable {
    Integer minAge;
    Integer maxAge;
}
