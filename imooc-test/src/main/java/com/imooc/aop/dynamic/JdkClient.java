package com.imooc.aop.dynamic;/**
 * @author Jerry
 * @version 2019-02-28
 */

import com.imooc.aop.RealSubject;
import com.imooc.aop.Subject;

import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:09
 * @Version 1.0
 **/
public class JdkClient {

    public static void main(String[] args) {
        // 生成代理class文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = (Subject) Proxy.newProxyInstance(JdkClient.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));

        subject.hello();
    }
}
