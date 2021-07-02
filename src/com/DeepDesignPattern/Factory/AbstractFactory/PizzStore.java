package com.DeepDesignPattern.Factory.AbstractFactory;

import com.DeepDesignPattern.Factory.PizzaFactory;

import java.util.Scanner;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:25
 */
public class PizzStore {

    private AbstractFactory pizzaFactory;

    public PizzStore(AbstractFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;

        do{

            String pizzaType = getPizzaType();
                Pizza pizza = pizzaFactory.CreatePizza(pizzaType);
            if(pizza != null)
            {
                pizza.cooking();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("没有改类型pizz 自动退出");
                break;
            }



        }while (true);


    }

    public String getPizzaType(){
        System.out.println("请输入你想要购买的pizza");
        Scanner scanner = new Scanner(System.in);
        String read = scanner.next();
        return read;
    }

    public static void main(String[] args) {

        //new PizzStore(new BJPizzaFactory());
        new PizzStore(new LDPizzaFactory());

    }

}
