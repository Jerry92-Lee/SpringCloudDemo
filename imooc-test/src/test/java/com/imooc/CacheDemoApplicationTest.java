package com.imooc;/**
 * @author Jerry
 * @version 2019-03-01
 */

import com.imooc.cache.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 10:25
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class CacheDemoApplicationTest {

    @Autowired
    MenuService menuService;

    @Test
    public void testCache(){
        System.out.println("call:"+menuService.getMenuList());
        System.out.println("call:"+menuService.getMenuList());
    }

    @Test
    public void testInnerCall(){
        System.out.println("call:"+menuService.getRecommends());
        System.out.println("call:"+menuService.getRecommends());
    }
}
