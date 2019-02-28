package com.imooc.test.aop.cglib;/**
 * @author Jerry
 * @version 2019-02-28
 */


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:25
 * @Version 1.0
 **/
public class CglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before in cglib ...");

        Object result = null;

        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            System.out.println("get ex:"+e.getMessage());
            throw e;
        } finally {
            System.out.println("after in cglib ...");
        }
        return result;
    }
}
