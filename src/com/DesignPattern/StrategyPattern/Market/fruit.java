package com.DesignPattern.StrategyPattern.Market;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/89:27
 */
public abstract class fruit {

    public fruit(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    private double price;

    private double weight;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }




}
