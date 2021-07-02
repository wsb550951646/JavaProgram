package com.Generice.GenericeInterface.CustomerPack;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2114:32
 */
public class Customer {

    private static Integer count = 0;

    private final long id = count++;

    public String toString(){

        return "Customer:"+id;
    }

    //匿名类 直接创建一个实现generator接口重写next方法的类
    public static generator<Customer> generator(){
        return new generator<Customer>(){
            public Customer next(){return new Customer();}
        };
    }


}
