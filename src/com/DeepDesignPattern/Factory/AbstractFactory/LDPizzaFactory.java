package com.DeepDesignPattern.Factory.AbstractFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1719:12
 */
public class LDPizzaFactory extends AbstractFactory {


    @Override
    Pizza CreatePizza(String pizzType) {
        Pizza pizza = null;
        System.out.println("使用工厂模式创建LDpizza");
        if(pizzType.equals("cheese")) {
            pizza = new LDCheesePizza();
            pizza.setName("LD奶酪");
        }else if(pizzType.equals("greek")){
            pizza = new LDGreekPizza();
            pizza.setName("LD希腊");
        }

        return pizza;

    }
}
