package com.imooc.test.aop.pattern;/**
 * @author Jerry
 * @version 2019-02-28
 */

import com.imooc.test.aop.RealSubject;
import com.imooc.test.aop.Subject;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 9:58
 * @Version 1.0
 **/
public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void hello() {
        realSubject.hello();
    }

    @Override
    public void request() {
        System.out.println("before");
        try {
            realSubject.request();
        }catch (Exception e){
            System.out.println("ex:"+e.getMessage());
            throw e;
        } finally {
            System.out.println("after");
        }
    }
}
