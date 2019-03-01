package com.imooc.aop.chain;/**
 * @author Jerry
 * @version 2019-02-28
 */

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 10:46
 * @Version 1.0
 **/
public abstract class Handler {

    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public void execute(){
        handleProcess();
        if(sucessor != null){
            sucessor.execute();
        }
    }

    protected abstract void handleProcess();
}
