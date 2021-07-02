package com.sweng.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1615:26
 */
public class Order<T> {

    private int age;
    private String name;
    private T orderT;

    public Order() {
    }

    public Order(int age, String name, T orderT) {
        this.age = age;
        this.name = name;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", orderT=" + orderT +
                '}';
    }

    /*
        泛型方法：在方法中出现泛型参数，且泛型参数与泛型类参数没有任何的关系

        换句话说：泛型方法的泛型参数与泛型类中的参数无关

        泛型方法可以为静态的

        注意：需要在public后面加入一个<E> 表示E是一个泛型参数  而不是一个E的对象类型

     */

    public <E> List<E> copyArrayToList(E[] array){

        List<E> arrayList = new ArrayList<>();

        for(E e:array){

            arrayList.add(e);
        }

        return arrayList;
    }
}
