package com.sweng.StaticThink.StaticCode;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2516:49
 */
public class parent {

    static int parentstaticValue = 10;

    static final int parentstaticfinalValue = 20;


    public  parent(){
        System.out.println("init parent");
    }

    static {

        System.out.println("parent static");

    }

    {
        System.out.println("parent formal");

    }


}
