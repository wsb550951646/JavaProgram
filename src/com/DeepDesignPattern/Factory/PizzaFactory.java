package com.DeepDesignPattern.Factory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:12
 */
public class PizzaFactory {



    public Pizza createPizza(String pizzType){
            Pizza pizza = null;
            System.out.println("使用工厂模式创建pizza");
            if(pizzType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName("奶酪");
            }else if(pizzType.equals("greek")){
                pizza = new GreekPizza();
                pizza.setName("希腊");
            }

        return pizza;
    }


}
