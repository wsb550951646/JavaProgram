package com.NIO.Serializtion;

import java.io.Serializable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1115:27
 */
public class Person implements Serializable{

    private String name;
    private Integer age;
   // private static final long serialVersionUID = 1L;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
        System.out.println("default");
    }
}
