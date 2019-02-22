package com.jerry.test.serviceRibbon.service;/**
 * @author Jerry
 * @version 2019-02-22
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 13:38
 * @Version 1.0
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String sayHello(String name){
        return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
    }

    public String error(String name){
        return "Sorry "+name+", service-ribbon is error !";
    }
}
