package com.DeepDesignPattern.Factory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:09
 */
public class CheesePizza extends Pizza {

    @Override
    public void prepare() {

        System.out.println("正在准备奶酪pizza的材料");

    }
}
