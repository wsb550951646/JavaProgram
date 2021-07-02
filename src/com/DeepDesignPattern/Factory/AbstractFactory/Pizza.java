package com.DeepDesignPattern.Factory.AbstractFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1316:07
 */
public abstract class Pizza {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void cooking(){
        System.out.println("正在制作"+name+"pizza");
    }

    public void cut(){
        System.out.println("正在切割"+name+"pizza");
    }

    public void box(){
        System.out.println("正在包装"+name+"pizza");
    }



}
