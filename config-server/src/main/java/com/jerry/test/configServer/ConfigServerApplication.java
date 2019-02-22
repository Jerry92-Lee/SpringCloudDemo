package com.jerry.test.configServer;/**
 * @author Jerry
 * @version 2019-02-22
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 14:53
 * @Version 1.0
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
