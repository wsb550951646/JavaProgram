package com.DesignPattern.StrategyPattern.Market;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/810:01
 */
public class Discount implements IStrategy{

    private double weight;

    private double price;

    public Discount(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void strategy() {

        if(this.getWeight() < 10) {
            System.out.println("水果未打折价钱:" + this.getWeight() * this.getPrice());
        }else if(this.getWeight() >= 10 && this.getWeight() < 50) {
            System.out.println("水果打八八折价钱:" + this.getWeight() * this.getPrice() * 0.88 );
        }else if(this.getWeight() >= 50) {
            System.out.println("水果打五折价钱:" + this.getWeight() * this.getPrice() * 0.5 );
        }

    }
}
