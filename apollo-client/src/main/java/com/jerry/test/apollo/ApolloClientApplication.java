package com.jerry.test.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jerry
 * @version 2019-03-18
 */
@SpringBootApplication
@EnableApolloConfig
public class ApolloClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloClientApplication.class, args);
    }
}
