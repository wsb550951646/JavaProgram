package com.sweng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1614:51
 */
public class GenericTest {

    @Test
    public void test() {


    }

    @Test
    public void testOrder() {

        //在order中没有规定泛型的类型  所以setOrderT 可以是int 也可以是String  代表是Object类型
        Order order = new Order();
        order.setOrderT(123);

        //在泛型中规定了String类型 setorderT 只能添加123的String类型
        Order<String> order1 = new Order<>();
        order1.setOrderT("123");

    }

    @Test
    public void testSub1() {

        //subOrder继承了Order<String> 所以subOder不是一个泛型类 其中orderT是一个String对象
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT("123");

    }

    @Test
    public void testSub2() {

        //没有设置泛型的种类，所以setOrderT的值为Object类型的
        SubOrder1 subOrder1 = new SubOrder1();
        subOrder1.setOrderT(123);
        subOrder1.setOrderT("123");


        //设置了泛型的类型String类型 注意：泛型类在前面设置后，后面可以不用写，系统会自动匹配
        SubOrder1<String> subOrder2 = new SubOrder1<>();
        subOrder2.setOrderT("123");
        //subOrder2.setOrderT(123);

    }

    @Test
    public void testGernericMethod() {

        Integer [] a = new Integer[]{1,2,3};
        Order<String> order = new Order<>();
        List<Integer> list = order.copyArrayToList(a);
        System.out.println(list);

    }

    //通配符的使用
    /*
        类A是类B的父类， G<A>与G<B>没有关系 二者的共同父类是：G<?>

        使用List<?>作为并列的list1 与 list2的通用父类

        达到可以使得 list1和list2 都可以赋值给list<?>类型的对象

        注意：不可以向List<?> list 中添加数据（null特例）

        但是允许读取数据

     */
    @Test
    public void testGernericSymbol(){

        List<String> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        list1 = Arrays.asList("1","2");
        list2 = Arrays.asList(1,2,3);

        Print(list1);
        Print(list2);


        //不可以添加 可以读取
        List<?> list3 = null;
        list3.add(null);

        Object o = list3.get(0);




    }

    //自动补全变量名和类名  ctrl+alt+v
    public static void Print(List<?> list){

        Iterator<?> iterator1 = list.iterator();

        while (iterator1.hasNext()){

            Object o = iterator1.next();
            System.out.println(o);

        }




    }
}
