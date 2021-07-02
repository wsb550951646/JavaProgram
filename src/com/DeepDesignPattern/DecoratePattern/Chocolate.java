package com.DeepDesignPattern.DecoratePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2017:33
 */
public class Chocolate extends Decorate {
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3);
    }
}
