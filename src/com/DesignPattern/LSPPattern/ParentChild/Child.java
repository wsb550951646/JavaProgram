package com.DesignPattern.LSPPattern.ParentChild;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2914:49
 */
public class Child extends Parent {

    @Override
    public void fun(int a, int b) {
        System.out.println("a-b"+(a-b));
    }


    public void fun2(Map map){

        System.out.println("子类实现");

    }

    public void fun3(HashMap hashMap){
        System.out.println("子类执行-fun3");
    }





}
