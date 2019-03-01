package com.imooc.aop.pattern;/**
 * @author Jerry
 * @version 2019-02-28
 */

import com.imooc.aop.RealSubject;
import com.imooc.aop.Subject;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:00
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
