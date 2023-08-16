package com.matovic.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("user_name")
    private String name;

    @Past(message = "BirthDate should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
