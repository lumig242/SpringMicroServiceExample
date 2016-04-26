package com.example;

/**
 * Created by Holysoul on 4/25/16.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockSymbolApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockSymbolApplication.class, args);
    }
}