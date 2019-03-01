package com.imooc.aop.cglib;/**
 * @author Jerry
 * @version 2019-02-28
 */

import com.imooc.aop.RealSubject;
import com.imooc.aop.Subject;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:33
 * @Version 1.0
 **/
public class CglibClient {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
