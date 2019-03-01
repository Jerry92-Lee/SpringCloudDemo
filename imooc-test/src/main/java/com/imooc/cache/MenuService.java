package com.imooc.cache;/**
 * @author Jerry
 * @version 2019-03-01
 */

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 10:21
 * @Version 1.0
 **/
@Service
public class MenuService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getMenuList(){
        System.out.println("");
        System.out.println("mock: get from db");
        return Arrays.asList("article","comment", "admin");
    }
}
