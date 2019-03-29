package com.jerry.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description 服务提供方
 * @Author Administrator
 * @Date 2019/2/22 11:38
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class ServiceHiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceHiApplication.class);

    public static void main(String[] args) {
        LOG.info("ServiceHiApplication is start ...");
        SpringApplication.run(ServiceHiApplication.class, args);
    }
}
