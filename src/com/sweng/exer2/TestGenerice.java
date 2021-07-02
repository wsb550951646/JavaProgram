package com.sweng.exer2;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/179:46
 */

/*
    使用泛型类创建类  使得类内的可以提供多种不确定的类对象，增加代码的复用性

    其中Person<T extends Info>  private T Tinfo;
    限制了T的范围  类对象是能是Info的子类或实现类的关系

 */
public class TestGenerice {

    public static void main(String[] args) {

        Person<Contact> personContact = new Person<>(new Contact(1234561,"浙江","123451"));

        Person<Introduction> introductionPerson = new Person<>(new Introduction("sweng","男",22));

        System.out.println(personContact);
        System.out.println(introductionPerson);

        ;



    }
}
