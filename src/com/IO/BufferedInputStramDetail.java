package com.IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/715:05
 */
public class BufferedInputStramDetail {

    public static void main(String[] args) throws IOException {

        byte[] b = {1,2,3,4,5,6,7,8,9,10};

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);

        BufferedInputStream bi = new BufferedInputStream(byteArrayInputStream,4);

        System.out.println("reand"+bi.read());  //读1
        System.out.println("reand"+bi.read());  //读2
        System.out.println("reand"+bi.read());  //读3

        System.out.println("mark");

        bi.mark(3);  //readlimit = 3

        System.out.println("reand"+bi.read());  //读4
        System.out.println("reand"+bi.read());  //读5
        System.out.println("reand"+bi.read());  //读6
        System.out.println("reand"+bi.read());  //读7






        bi.reset();
        System.out.println("---");
        int c;
        while ( (c = bi.read()) != -1 ) {
            System.out.print(c + ",");
        }


    }


}
