package com.matovic.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
//@JsonIgnoreProperties("field1")
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    String field1;

    //@JsonIgnore
    String field2;
    String field3;
}
