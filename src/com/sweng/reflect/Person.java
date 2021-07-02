package com.sweng.reflect;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1713:33
 */
public class Person {

    private String name;
    public int age;
    private Child child;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    private Person(String name)
    {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void show(){
        System.out.println("这是一个没有参数的方法");
    }

    private void show(String args){
        System.out.println("这是一个带参数的方法"+args);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
