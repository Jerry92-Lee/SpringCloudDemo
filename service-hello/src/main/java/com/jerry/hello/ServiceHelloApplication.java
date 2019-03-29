package com.jerry.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jerry
 * @version 2019-03-28
 */

@SpringBootApplication
@EnableEurekaClient
public class ServiceHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHelloApplication.class, args);
    }
}
