package com.matovic.rest.webservices.restfulwebservices.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@ToString
public class User {

    private Integer id;
    private String name;
    private LocalDate birthDate;
}
