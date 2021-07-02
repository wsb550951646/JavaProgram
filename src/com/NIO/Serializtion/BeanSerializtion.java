package com.NIO.Serializtion;

import java.io.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1115:27
 */
public class BeanSerializtion implements Serializable {

    public static void main(String[] args) throws Exception {
        final String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";


        FileOutputStream fout = new FileOutputStream(fileName);
        Person person = new Person("1", 12);

        //写入对象的序列化信息
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(person);
        oos.writeObject(person);
        oos.close();
        fout.close();

        FileOutputStream fout2 = new FileOutputStream(fileName);
        ObjectOutputStream oos1 = new ObjectOutputStream(fout2);
        oos1.writeObject(person);
        oos1.close();
        fout2.close();



        //读取对象的序列化信息
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream oin = new ObjectInputStream(fin);
        Object object1 = oin.readObject();
        //Object object2 = oin.readObject();
        Person p = (Person)object1;
        //Person p2 = (Person)object2;
        System.out.println("p1:"+p);
        System.out.println(p.getAge()+p.getName());
        //System.out.println("p2:"+p2);





        //序列化完后  equals不相同了
       // System.out.println("序列化后相同吗？"+person.equals(p));
        //System.out.println(person==p);


    }




}
