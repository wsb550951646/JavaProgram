package com.Generice.GenericeInterface.ErasePack.EraseLearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2315:00
 */
public class ListMaker<T> {

    List<T> create(){

        return new ArrayList<T>();
        //return new ArrayList();
    }

    List<T> create(T t,int n){

        List<T> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(t);
        }
        return a;
    }


    /*
    1.尽管我们从擦除中知道，在create（）内部的new ArraList<T>中的T被移除了--在运行中，内部没有任何T，因此看起来毫无意思。
    但是在代码中返回  new ArrayList() 中又产生报错

    2.即使Create（T t,int n）中T的任何信息，任然可以在编译期确保放在正确。
    擦除在方法或类内部移除了有关实际类型信息，编译器任可以确保方法或者类中使用类型的内部一致性

     */
    public static void main(String[] args) {

        ListMaker<String> stringListMaker = new ListMaker<>();
        List<String> strings = stringListMaker.create();

        List<String> hh = stringListMaker.create("HH", 3);
        for (String s:hh){
            System.out.println(s);
        }

    }

}
