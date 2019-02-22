package com.jerry.test.service.Api;/**
 * @author Jerry
 * @version 2019-02-22
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 11:39
 * @Version 1.0
 **/
@RestController
public class ServiceHiApi {

    @Value("${server.port}")
    public String port;

    @GetMapping("/hi")
    public void sayHi(String name) {
        System.out.println("Hi, " + name + "! I am from port:" + port);
    }
}
