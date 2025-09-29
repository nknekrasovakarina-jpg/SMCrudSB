package com.example.smcrudsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan(basePackages = "com.example.entity")
public class SmCrudSbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmCrudSbApplication.class, args);
    }
}