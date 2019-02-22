package com.jerry.test.serviceRibbon.Api;/**
 * @author Jerry
 * @version 2019-02-22
 */

import com.jerry.test.serviceRibbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 13:37
 * @Version 1.0
 **/
@RestController
public class HelloApi {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(String name){
        return helloService.sayHello(name);
    }

}
