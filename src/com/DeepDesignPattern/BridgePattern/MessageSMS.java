package com.DeepDesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2015:15
 */
public class MessageSMS implements MessageImplementor {
    @Override
    public void send(String msg,String usr) {
        System.out.println(msg+" -"+usr+" -Send Message with SMS");
    }
}
