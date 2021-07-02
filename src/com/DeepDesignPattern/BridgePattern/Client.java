package com.DeepDesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2015:19
 */
public class Client {

    public static void main(String[] args) {

        UrgencyMessage urgencyMessage = new UrgencyMessage(new MessageEmail());
        urgencyMessage.sendMessage("加班审批", "李总");
        urgencyMessage.onWatch();

        CommonMessage commonMessage = new CommonMessage(new MessageSMS());
        commonMessage.sendMessage("加班审批", "王总");


        CommonMessage commonMessage1 = new CommonMessage(new MessageEmail());
        commonMessage1.sendMessage("1", "2");

    }

}
