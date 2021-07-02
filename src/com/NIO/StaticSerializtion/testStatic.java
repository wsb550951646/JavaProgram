package com.NIO.StaticSerializtion;

import java.io.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/129:50
 */
public class testStatic {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName2 = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";
        FileOutputStream fout = new FileOutputStream(new File(fileName2).getAbsoluteFile());

        bean b = new bean();
        bean.setI(1);
        bean.setS("test");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

        objectOutputStream.writeObject(b);

        FileInputStream fin = new FileInputStream(new File(fileName2).getAbsoluteFile());
        ObjectInputStream objectInputStream = new ObjectInputStream(fin);
        bean object = (bean)objectInputStream.readObject();
        System.out.println(object);


    }


}
