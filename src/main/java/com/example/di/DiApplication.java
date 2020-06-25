package com.example.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiApplication.class, args);
    }

}
