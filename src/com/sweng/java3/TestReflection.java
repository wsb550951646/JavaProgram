package com.sweng.java3;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1810:45
 */
public class TestReflection {

    @Test
    public void test1() throws Exception {

        //测试访问  私有属性
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();

        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);

        name.set(person, "Tom");

        System.out.println(person);

        //测试访问 有参数私有方法
        Method show = clazz.getDeclaredMethod("showParam", String.class);

        show.setAccessible(true);

        show.invoke(person, "测试代码");

        //测试访问 无参数方法

        Method show1 = clazz.getDeclaredMethod("show", null);

        show1.setAccessible(true);

        show1.invoke(person, null);




    }


}
