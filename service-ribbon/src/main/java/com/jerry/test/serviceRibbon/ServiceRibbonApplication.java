package com.jerry.test.serviceRibbon;/**
 * @author Jerry
 * @version 2019-02-22
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 客户端负载均衡
 * @Author Administrator
 * @Date 2019/2/22 13:31
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //向服务中心注册
@EnableHystrix  //打开Hystrix断路器
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced //表明这个restRemplate开启负载均衡的功能
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
