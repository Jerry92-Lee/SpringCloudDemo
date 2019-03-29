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
public class ServiceSleuthHiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceSleuthHiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceSleuthHiApplication.class, args);

        LOG.info("ServiceSleuthHiApplication is start ...");
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome(){
        LOG.info("calling trace service-sleuth-hi.callHome() ...");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info(){
        LOG.info("calling trace service-sleuth-hi.info() ...");

        return "i'm service-sleuth-hi";
    }
}
