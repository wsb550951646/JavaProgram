package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:32
 */
public class ToyDuck extends Duck {

    public ToyDuck(FlyBehavor flyBehavor) {
        super(flyBehavor);
    }

    @Override
    public void fly() {

        System.out.println("我是玩具鸭子");
        flyBehavor.fly();
    }
}
