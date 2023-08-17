package com.matovic.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "user_details")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name should be with size at least 2 characters")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "BirthDate should be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
