package com.matovic.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @Size(min=2, message = "Name should be with size at least 2 characters")
    private String name;

    @Past(message = "BirthDate should be in the past")
    private LocalDate birthDate;
}
