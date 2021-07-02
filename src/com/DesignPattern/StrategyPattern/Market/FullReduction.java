package com.DesignPattern.StrategyPattern.Market;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/89:54
 */
public class FullReduction implements IStrategy{

    private double price;

    private double weight;

    public FullReduction(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

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

    @Override
    public void strategy() {
        if(this.getWeight() * this.getPrice() < 10) {
            System.out.println("水果未打折价钱:" + this.getWeight() * this.getPrice());
        }else if(this.getWeight() * this.getPrice() >= 10 && this.getWeight() * this.getPrice() < 20) {
            System.out.println("水果购买满10元立减1角:" + (this.getWeight() * this.getPrice() - 0.1) );
        }else if(this.getWeight() * this.getPrice() >= 20 && this.getWeight() * this.getPrice() < 30) {
            System.out.println("水果购买满20元立减1元:" + (this.getWeight() * this.getPrice() - 1) );
        }else if(this.getWeight() * this.getPrice() >= 30) {
            System.out.println("水果购买满30元立减5元:" + (this.getWeight() * this.getPrice() - 5) );
        }

    }
}
