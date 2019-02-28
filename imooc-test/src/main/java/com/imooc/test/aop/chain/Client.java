package com.imooc.test.aop.chain;/**
 * @author Jerry
 * @version 2019-02-28
 */

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:48
 * @Version 1.0
 **/
public class Client {

    static class HandlerA extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by a ...");
        }
    }

    static class HandlerB extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by b ...");
        }
    }

    static class HandlerC extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by c ...");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSucessor(handlerB);
        handlerB.setSucessor(handlerC);

        handlerA.execute();
    }
}
