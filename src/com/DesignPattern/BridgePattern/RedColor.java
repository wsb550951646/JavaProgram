package com.DesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/814:06
 */
public class RedColor implements IColor {
    @Override
    public void color() {
        System.out.println("红色的毛笔");
    }
}
