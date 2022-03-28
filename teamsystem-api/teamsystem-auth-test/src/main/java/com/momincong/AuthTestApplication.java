package com.momincong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthTestApplication.class, args);
    }

}