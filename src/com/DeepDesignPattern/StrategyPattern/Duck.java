package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:29
 */
public abstract class Duck {

    FlyBehavor flyBehavor;

    public Duck(FlyBehavor flyBehavor) {
        this.flyBehavor = flyBehavor;
    }

    public abstract void fly();

}
