package com.example;

import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionalExamplesApplication {
    private final ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionalExamplesApplication.class, args);
    }


    @Bean
    public CommandLineRunner run() {
        return args -> {
            productService.createProductWithCreateOrderMethodAndThrowRuntimeException();
        };
    }


}
