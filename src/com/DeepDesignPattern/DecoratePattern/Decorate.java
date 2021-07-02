package com.DeepDesignPattern.DecoratePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2017:26
 */
public class Decorate extends Drink{


    private Drink obj;

    public Decorate(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return obj.cost() + super.getPrice();
    }

    @Override
    public String getDes() {
        return des + " "+super.getPrice() + " &&"+obj.getDes();
    }
}
