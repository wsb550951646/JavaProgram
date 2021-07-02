package com.DesignPattern.LSPPattern.ParentChild;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2914:48
 */
public class Parent {

    public void fun(int a,int b){

        System.out.println("a+b="+(a+b));

    }

    public void fun2(HashMap hashMap){

        System.out.println("父类执行");

    }

    public void fun3(Map map){

        System.out.println("父类执行-fun3");
    }

    public void fun4(){
        System.out.println("fu-4");
    }

}
