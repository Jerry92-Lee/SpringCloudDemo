package com.imooc.test.aop.dynamic;/**
 * @author Jerry
 * @version 2019-02-28
 */

import com.imooc.test.aop.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:06
 * @Version 1.0
 **/
public class JdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("after");
        }
        return result;
    }
}
