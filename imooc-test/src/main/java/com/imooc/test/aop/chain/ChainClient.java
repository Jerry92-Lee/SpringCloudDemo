package com.imooc.test.aop.chain;/**
 * @author Jerry
 * @version 2019-02-28
 */

import java.util.Arrays;
import java.util.List;

/**
 * @Description 责任链模式
 * @Author Administrator
 * @Date 2019/2/28 11:00
 * @Version 1.0
 **/
public class ChainClient {

    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by chain a");
        }
    }

    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by chain b");
        }
    }

    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by chain c");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(), new ChainHandlerB(), new ChainHandlerC());

        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
