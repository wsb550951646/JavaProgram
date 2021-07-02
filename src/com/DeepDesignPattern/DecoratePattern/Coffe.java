package com.DeepDesignPattern.DecoratePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2017:20
 */
public class Coffe extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
