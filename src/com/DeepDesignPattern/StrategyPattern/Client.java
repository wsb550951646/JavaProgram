package com.DeepDesignPattern.StrategyPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2516:34
 */
public class Client {

    public static void main(String[] args) {

        BJDuck bjDuck = new BJDuck(new GoodFlyBehavor());
        bjDuck.fly();

        ToyDuck toyDuck = new ToyDuck(new BadFlyBehavor());
        toyDuck.fly();

        WideDuck wideDuck = new WideDuck(new GoodFlyBehavor());
        wideDuck.fly();


    }

}
