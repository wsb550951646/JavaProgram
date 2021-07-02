package com.DeepDesignPattern.Factory.AbstractFactory;

import com.DeepDesignPattern.Factory.GreekPizza;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1719:11
 */
public class BJPizzaFactory extends AbstractFactory {

    @Override
    Pizza CreatePizza(String pizzType) {
        Pizza pizza = null;
        System.out.println("使用工厂模式创建BJpizza");
        if(pizzType.equals("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("BJ奶酪");
        }else if(pizzType.equals("greek")){
            pizza = new BJGreekPizza();
            pizza.setName("BJ希腊");
        }

        return pizza;

    }
}
