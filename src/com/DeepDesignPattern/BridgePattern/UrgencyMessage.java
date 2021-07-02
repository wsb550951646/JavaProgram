package com.DeepDesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2015:16
 */
public class UrgencyMessage extends AbstractMessage {

    public UrgencyMessage(MessageImplementor messageImplementor) {
        super(messageImplementor);
    }

    @Override
    public void sendMessage(String msg, String usr) {

        msg = "加急信息-"+msg;
        super.sendMessage(msg, usr);
    }

    //拓展自己的方法
    public void onWatch(){

    }
}
