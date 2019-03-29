package com.jerry.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jerry
 * @version 2019-03-16
 */
@SpringBootApplication
@RestController
public class ServiceSleuthHelloApplication {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceSleuthHelloApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ServiceSleuthHelloApplication.class, args);
        LOG.info("ServiceSleuthHelloApplication is start ...");
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(){
        LOG.info("calling trace service-sleuth-hello.home() ...");
        return "i'm service-sleuth-hello";
    }

    @RequestMapping("/miya")
    public String info(){
        LOG.info("calling trace service-sleuth-hello.info() ...");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }


}
