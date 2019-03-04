package com.imooc;/**
 * @author Jerry
 * @version 2019-02-25
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/25 14:21
 * @Version 1.0
 **/
@SpringBootApplication
public class ImoocApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImoocApplication.class, args);
    }
}
