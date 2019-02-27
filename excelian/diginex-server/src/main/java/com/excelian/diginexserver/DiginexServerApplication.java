package com.excelian.diginexserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DiginexServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.excelian.diginexserver.DiginexServerApplication.class, args);
    }

}

