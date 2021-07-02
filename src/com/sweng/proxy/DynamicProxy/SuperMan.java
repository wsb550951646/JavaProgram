package com.sweng.proxy.DynamicProxy;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1814:02
 */
public class SuperMan implements Human{
    @Override
    public void eat() {
        System.out.println("喜欢吃东西");
    }

    @Override
    public String believe() {
        return "I believe I can fly";
    }

    @Override
    public void sing(String song) {
        System.out.println(song);
    }

}
