package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:26
 */
public class BadFlyBehavor implements FlyBehavor {
    @Override
    public void fly() {
        System.out.println("不会飞行");
    }
}
