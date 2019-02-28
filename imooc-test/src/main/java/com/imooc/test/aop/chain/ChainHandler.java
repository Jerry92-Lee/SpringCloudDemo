package com.imooc.test.aop.chain;/**
 * @author Jerry
 * @version 2019-02-28
 */

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:55
 * @Version 1.0
 **/
public abstract class ChainHandler {

    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();


}
