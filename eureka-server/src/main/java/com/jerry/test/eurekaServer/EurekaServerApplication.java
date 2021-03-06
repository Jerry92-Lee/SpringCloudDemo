package com.jerry.test.eurekaServer;/**
 * @author Jerry
 * @version 2019-02-22
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description 注册中心-EurekaServer
 * 维护服务生产者、注册中心、服务消费者三者之间的关系。
 *
 * @Author Administrator
 * @Date 2019/2/22 11:31
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
