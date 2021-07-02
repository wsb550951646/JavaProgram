package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:33
 */
public class WideDuck extends Duck{
    public WideDuck(FlyBehavor flyBehavor) {
        super(flyBehavor);
    }

    @Override
    public void fly() {

        System.out.println("我是野鸭子");
        flyBehavor.fly();
    }
}
