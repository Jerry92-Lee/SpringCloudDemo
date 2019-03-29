package com.jerry.test.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jerry
 * @version 2019-03-18
 */
@SpringBootApplication
@EnableAdminServer
public class SpringAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdminServerApplication.class, args);
    }
}
