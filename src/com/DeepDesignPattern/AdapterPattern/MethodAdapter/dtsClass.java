package com.DeepDesignPattern.AdapterPattern.MethodAdapter;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1913:26
 */
public class dtsClass extends AbsAdapter {

    public static void main(String[] args) {

        //可以根据需要重写自己想要的方法
        dtsClass d = new dtsClass(){
            @Override
            public void m1() {
                System.out.println("重写m1方法");
            }

            @Override
            public void m2() {
                System.out.println("重写m2方法，其他不管");
            }
        };

        d.m1();
        d.m2();
        d.m3();


    }

}
