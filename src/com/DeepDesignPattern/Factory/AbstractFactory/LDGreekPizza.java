package com.DeepDesignPattern.Factory.AbstractFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:10
 */
public class LDGreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("正在准备LD希腊pizza");
    }
}
