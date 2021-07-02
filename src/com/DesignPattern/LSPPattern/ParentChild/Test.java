package com.DesignPattern.LSPPattern.ParentChild;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2914:50
 */
public class Test {

    public static void main(String[] args) {

        //1. LSP 里氏替换原则  父类出现的地方，子类都可以替换。 但是重写的父类方法替换掉，会出现与父类的不同的问题

        Parent parent = new Parent();
        parent.fun(2, 1);


        Child child = new Child();
        child.fun(2, 1);


        /*
              2. 子类的参数类型要比父类的参数类型宽松（这要 对父类的修改方法就是重载（参数不同）方法名字相同）

                Map --> HashMap --> LinkedHashMap  所以子类的重载方法（传递的参数要比父类传递的参数范围大，这样可以避免出现替换父类方法而去调用子类方法）

         */



        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap<>();
        HashMap hashMap1 = new HashMap<>();


        parent.fun2(objectObjectHashMap);

        child.fun2(objectObjectHashMap);

        child.fun2(linkedHashMap);

        child.fun2(hashMap1);


        //3. 子类的参数类型比父类的参数类型小  （会发生替换父类的方法，而去调用了子类的方法，造成错误）
        HashMap hashMap = new HashMap<>();

        parent.fun3(hashMap);

        child.fun3(hashMap);   //该方法调用了子类发fun3方法


        parent.fun4();

        child.fun4();


    }
}
