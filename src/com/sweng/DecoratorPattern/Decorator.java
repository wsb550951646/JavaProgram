package com.sweng.DecoratorPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/5/910:26
 */
public class Decorator implements food {

    protected food food;

    public Decorator(food food) {
        this.food = food;
    }


    @Override
    public String getdescfood() {
        return food.getdescfood();
    }

    @Override
    public String getCost() {
        return food.getCost();
    }
}
