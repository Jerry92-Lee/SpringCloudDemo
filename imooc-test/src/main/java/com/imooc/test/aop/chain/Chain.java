package com.imooc.test.aop.chain;/**
 * @author Jerry
 * @version 2019-02-28
 */

import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:55
 * @Version 1.0
 **/
public class Chain {

    private List<ChainHandler> handlers;

    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed() {
        if (index >= handlers.size()) {
            return;
        }
        handlers.get(index++).execute(this);
    }
}
