package com.DeepDesignPattern.Factory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:10
 */
public class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("正在准备希腊pizza");
    }
}
