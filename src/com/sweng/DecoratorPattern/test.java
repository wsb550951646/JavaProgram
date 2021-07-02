package com.sweng.DecoratorPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/5/910:35
 */
public class test {

    /*
        装饰类设计模式：
            使用装饰类设计模式，可以在不改变原先的功能情况下，去修改类的功能，起到装饰的效果

            例如：接口food 有描述 价格 方法
            HotPot BarBecue 分别取实现该接口，实现不同的描述

            若想在不改变原先的功能上，增加一些修饰的方法，则通过修饰类，将hotPot BarBecue包装起来
            达到装饰类效果，增加功能

            Decorator类

     */
    public static void main(String[] args) {

        HotPotFood hotPotFood = new HotPotFood();
        BarBecueFood barBecueFood = new BarBecueFood();

        Decorator decorator  = new SaltDecorator(hotPotFood);
        Decorator decorator1 = new SaltDecorator(barBecueFood);
        System.out.println(decorator.getdescfood());
        System.out.println(decorator.getCost());

        System.out.println(decorator1.getdescfood());
        System.out.println(decorator1.getCost());

    }

}
