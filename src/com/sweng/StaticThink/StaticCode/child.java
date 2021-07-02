package com.sweng.StaticThink.StaticCode;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2516:49
 */
public class child extends parent {

    static int childstaticValue = 1;

    static final int childstaticfinalValue = 2;

    public  child(){
        System.out.println("init child");
    }

    static {

        System.out.println("child static");

    }

    {
        System.out.println("child formal");

    }

}
