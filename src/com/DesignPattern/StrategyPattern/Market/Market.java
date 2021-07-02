package com.DesignPattern.StrategyPattern.Market;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/89:26
 */
public class Market{

    public static List<fruit> fruitShoppingCart = new ArrayList<>();

    public static StrategyContainer strategyContainer = new StrategyContainer();

    public double totalPrice(){

        double totalPrice = 0;

        for(fruit fruit: fruitShoppingCart){

            totalPrice += fruit.getPrice();

        }

        return totalPrice;
    }

    public double totalWeight(){

        double totalWeight = 0;

        for(fruit fruit: fruitShoppingCart){

            totalWeight += fruit.getWeight();
        }

        return totalWeight;
    }

    public static void main(String[] args) {

        Apple apple = new Apple(10.35, 10);
        Banan banan = new Banan(14.35, 3.6);

        Market market = new Market();

        fruitShoppingCart.add(apple);
        fruitShoppingCart.add(banan);

        double totalprice = market.totalPrice();

        double totalWeight = market.totalWeight();

        //strategyContainer.setiStrategy(new FullReduction(totalprice,totalWeight));
        strategyContainer.setiStrategy(new Discount(totalWeight,totalprice));


        strategyContainer.operation();



    }




}
