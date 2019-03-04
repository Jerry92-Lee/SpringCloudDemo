package com.imooc.cache;/**
 * @author Jerry
 * @version 2019-03-04
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/4 10:10
 * @Version 1.0
 **/
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext ctx;

    public static ApplicationContext getCtx() {
        return ctx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
