package com.matovic.rest.webservices.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;
}
