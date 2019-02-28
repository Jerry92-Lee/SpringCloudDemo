package com.jerry.test.configClient;/**
 * @author Jerry
 * @version 2019-02-22
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 15:50
 * @Version 1.0
 **/
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    public String foo;

    public String hi(){
        return foo;
    }
}
