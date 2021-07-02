package com.sweng.java3;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1810:43
 */
public class Person {

    private String name;
    public  int age;
    int id;

    public Person() {
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void show(){
        System.out.println("我是无参数的方法");
    }

    private void showParam(String name){
        System.out.println("我是有参数的方法："+name);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

}
