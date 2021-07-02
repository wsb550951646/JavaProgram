package com.sweng.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1616:55
 */
public class TestGenerice {


    /*
        站位符？的限制  List<? extends ...>  等价于 ？ <= ...
                     List<? super .....>  等价于 ？ >= ...
     */

    public void test(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;


        List<Student> students = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        List<Object> Objects = new ArrayList<>();

        //规律：赋值左边的是父类  右边的是子类


        //测试赋值
        list1 = students;
        list1 = persons;
        //list1 = Objects;  list1对象无法用Object赋值

        list2 = persons;
        list2 = Objects;
       //list2 = students;  list2对象无法用Students赋值

        //取数据
        Person p = list1.get(0);
        Object o = list1.get(0);
        //Student s = list1.get(0);


        Object o1 = list2.get(0);
        //Person p1 = list2.get(0);
        // Student s1 = list2.get(0);

        //List<? extend Person>添加数据 只有上界 所以下界无限 只能取不能添加
        //list1.add(new Student());
        //list1.add(new Person());

        list2.add(new Student());
        list2.add(new Person());







    }

}
