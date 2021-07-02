package com.DeepDesignPattern.Factory.AbstractFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:09
 */
public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {

        System.out.println("正在准备LD奶酪pizza的材料");

    }
}
