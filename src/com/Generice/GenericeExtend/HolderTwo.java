package com.Generice.GenericeExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2514:36
 */
public class HolderTwo {


    public static <T> void show1(List<T> list){

        for(Object object:list){
            System.out.println(object.getClass().getTypeName());
        }

    }

    public static void show2(List<?> list){

        for(Object object:list){
            System.out.println(object.getClass().getTypeName());
        }

    }

    public static void show3(List<? extends Fruit> list){

        for(Object object:list){
            System.out.println(object.getClass().getTypeName());
        }

    }

    public static void show4(List<? super Fruit> list){

        for (Object object:list){
            System.out.println(object.getClass().getTypeName());
        }

    }


    public static void main(String[] args) {

        System.out.println("---1---");
        List<Fruit> list = new ArrayList<Fruit>();
        list.add(new Orange());
        list.add(new Apple());
        //list.add(new BaseFruit());   指定了Fruit 不能添加非Fruit子类的类
        show1(list);

        System.out.println("---2---");
        List list1 = new ArrayList();
        list1.add(new Orange());
        list1.add(new Apple());
        list1.add(new BaseFruit());
        show2(list1);

        System.out.println("---？ extend Fruit---");
        List<BaseFruit> baseFruitList = new ArrayList<BaseFruit>();
        //show3(baseFruitList);  编译失败  ？ extend Fruit 只能接受 List的类型信息是 Fruit 以及其子类的

        List<Apple> appleList = new ArrayList<Apple>();
        appleList.add(new Apple());
        show3(appleList);       //? extend Fruit 可以接收List类型信息是Fruit的子类 Apple

        show3(list1);           //? extend Fruit 可以接收没有类型信息 List的参数
        show3(list);


        System.out.println("---？ super Fruit---");

        show4(list1);
        show4(list);
        //show4(appleList);   ? super Fruit 中不可以接受 Fruit的子类





    }

}
