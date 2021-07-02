package com.DeepDesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2015:07
 */
public abstract class AbstractMessage {

    private MessageImplementor messageImplementor;

    public AbstractMessage(MessageImplementor messageImplementor) {
        this.messageImplementor = messageImplementor;
    }

    public void sendMessage(String msg,String usr){

        messageImplementor.send(msg,usr);

    }
}
