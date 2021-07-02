package com.sweng.reflect;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1713:34
 */
public class TestFlect
{

    @Test
    public void Tests(){

        Byte x1 = 1;
        double xxxxxx = (double)x1;
        String x = "1.2.3";

        if(x.contains(".")){

            int i = x.indexOf(".");
            String substring = x.substring(0, i);
            String last = x.substring(i+1);
            System.out.println(substring);
            System.out.println(last);
        }

        //System.out.println(split1[0]);
        //System.out.println(split1[1]);

    }


    public Object doMethod(Object object,String methodName) throws Exception{

        String Realmethod = methodName;
        String nextMethod = null;
        if(methodName.contains(".")){
            int index = methodName.indexOf(".");
            Realmethod = methodName.substring(0, index);
            nextMethod = methodName.substring(index+1);
        }

        Realmethod = "get"+Realmethod;
        Object invoke = object.getClass().getMethod(Realmethod, new Class[]{}).invoke(object, new Object[]{});

        if(nextMethod!=null){
            invoke = doMethod(invoke, nextMethod);
        }
        return invoke;
    }

    @Test
    public void testMethod() throws Exception {
        try {

            List<String> list = Arrays.asList("3", "2", "1");
            System.out.println(list.get(0));
            for(String xxx: list){
                System.out.println(xxx);
            }

            Person person = new Person();
            person.setChild(new Child("sss"));
            person.setAge(111);

            Object o = doMethod(person, "Age");

            Object getChild = person.getClass().getMethod("getChild", new Class[]{}).invoke(person, new Object[]{});

            //Child child = (Child)doMethod(person.getClass(), "Child");
            //System.out.println(getChild);

            Object getChildName = getChild.getClass().getMethod("getChildName", new Class[]{}).invoke(getChild, new Object[]{});
        }catch (Exception e){

        }
    }

    @Test
    public void test() throws Exception {

        //调用的公用的
        //设置construction的结构
        Class clazz = Person.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class,int.class);

        Object o = constructor.newInstance("Tom", 13);

        Person person = (Person)o;

        System.out.println(person);

        //反射 调用属性           getDeclaredField方法
        // age应该为public的内容 使用private不能获取到
        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person);

        //反射 调用没有参数的方法   getDeclareMethod方法
        Method show = clazz.getDeclaredMethod("show", null);
        show.invoke(person, null);

        Class clazz1 = Person.class;




        //私有的调用
        System.out.println("-----------------");
        //调用私有构造器
        Constructor constructor1 = clazz1.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Object o1 = constructor1.newInstance("Jerry");

        Person person1 = (Person)o1;

        System.out.println(person1);

        //调用私有的属性
        Field name = clazz1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Jerry1");
        System.out.println(person1);

        //调用私有的方法 且带参数的
        Method show1 = clazz1.getDeclaredMethod("show", String.class);
        show1.setAccessible(true);
        show1.invoke(person1, "参数1");


    }

    //获取class实例的几种方式
    @Test
    public void test1() throws ClassNotFoundException {

        //方式一：运行时类的属性
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三：通过静态的Class方法
        Class<?> clazz3 = Class.forName("com.sweng.reflect.Person");
        System.out.println(clazz3);

        //方式四：通过classLoader的方式
        TestFlect testreflect = new TestFlect();
        ClassLoader classLoader = testreflect.getClass().getClassLoader();
        Class clazz4 = classLoader.loadClass("com.sweng.reflect.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
        System.out.println(clazz1==clazz4);


    }


}
