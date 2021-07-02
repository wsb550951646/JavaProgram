package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:27
 */
public class GoodFlyBehavor implements FlyBehavor {
    @Override
    public void fly() {

        System.out.println("飞行技能非常好");
    }
}
