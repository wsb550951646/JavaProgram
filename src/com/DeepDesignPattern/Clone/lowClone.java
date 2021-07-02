package com.DeepDesignPattern.Clone;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/189:57
 */
public class lowClone {

    public static void main(String[] args) throws Exception {

        Person person1 = new Person("person1", "1");
        CloneClass cloneClass = new CloneClass("cloneClass", person1);

        CloneClass cloneClass2 = (CloneClass)cloneClass.clone();

        CloneClass cloneClass3 = cloneClass.Myclone();

        CloneClass cloneClass4 = cloneClass.deepClone();

        display(cloneClass, 1);


        cloneClass.getPerson().setAge("2");
        cloneClass.setName("cloneClass2");

        display(cloneClass2, 2);

        display(cloneClass3, 3);
        display(cloneClass4, 4);

    }
    public static void display(CloneClass cloneClass,int i){

        System.out.println("------");
        System.out.println("地址:"+i+cloneClass);
        System.out.println("hascode"+i+"="+cloneClass.hashCode());
        System.out.println("person地址"+i+"="+cloneClass.getPerson());
        System.out.println("person hascode"+i+"="+ cloneClass.getPerson().hashCode());
        System.out.println("age"+i+"="+cloneClass.getPerson().getAge());
        System.out.println("cloName"+i+"="+cloneClass.getName());

    }


}
