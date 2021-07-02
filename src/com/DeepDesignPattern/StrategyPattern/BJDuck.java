package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:33
 */
public class BJDuck extends Duck {

    public BJDuck(FlyBehavor flyBehavor) {
        super(flyBehavor);
    }

    @Override
    public void fly() {

        System.out.println("我是北京鸭子");
        flyBehavor.fly();
    }
}
