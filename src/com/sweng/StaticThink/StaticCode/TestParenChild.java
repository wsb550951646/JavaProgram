package com.sweng.StaticThink.StaticCode;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2516:53
 */
public class TestParenChild {

    public static void main(String[] args) {

        /*
                new child()

            1. 父类子类 调用static{}  {}  构造器的顺序

            父类static{}  子类static{}  父类{} 父构造  子{}  子构造


         */


        /* 1. 取 static final 的域值不会调用 static{}
        System.out.println(child.childstaticfinalValue);
        System.out.println("after");

           2. 取 static 时会调用  static{}
        System.out.println(child.childstaticValue);


           3.  class forName 会调用static{}的内容  .class 则不会调用static{}
        Class c = child.class;

        try {
            Class<?> child1 = Class.forName("com.sweng.StaticThink.StaticCode.child");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        */

    }

}
