package com.DesignPattern.StrategyPattern.Market;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/89:52
 */
public class Gift implements IStrategy {

    @Override
    public void strategy() {
        System.out.println("买一斤送一斤");
    }
}
