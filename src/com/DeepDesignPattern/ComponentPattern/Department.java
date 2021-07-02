package com.DeepDesignPattern.ComponentPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2311:23
 */
public class Department extends AbstractComponent {


    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public void display() {

        System.out.println("---"+getName()+"-"+getDes()+"---");

    }
}
