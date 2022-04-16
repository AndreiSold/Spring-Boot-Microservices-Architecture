package com.example.cloudgateway;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallback")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String userServiceFallbackMethod() {
        return "User Service is taking longer than expected. Please try again later.";
    }

    @GetMapping("/departmentServiceFallback")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String departmentServiceFallbackMethod() {
        return "Department Service is taking longer than expected. Please try again later.";
    }
}
