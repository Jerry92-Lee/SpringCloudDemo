package com.imooc.test.aop;/**
 * @author Jerry
 * @version 2019-02-28
 */

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 9:54
 * @Version 1.0
 **/
public class RealSubject implements Subject {
    @Override
    public void hello() {
        System.out.println("hello ...");
    }

    @Override
    public void request() {
        System.out.println("real subject execute subject ...");
    }
}
