package com.DeepDesignPattern.CommandPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2416:32
 */
public class Client {

    public static void main(String[] args) {


        RemoteController remote = new RemoteController();
        LightReceived lightReceived = new LightReceived();
        remote.SetCommand(0, new LightOnCommand(lightReceived),new LightOffCommand(lightReceived));

        remote.button_on(0);
        remote.button_off(0);
        remote.button_undo();


    }

}
