package com.IO.IOUtils;

import com.IO.BufferedInputFile;

import java.io.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/615:27
 */

/*

        BufferInputStream 流中的  read(byte[]) 方法

        源码解析



 */
public class BinaryFile {

    public static byte[] read(File bFile) throws IOException {

        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
           
            return data;
        }finally {
            bf.close();
        }

    }

    public static byte[] read(String bFile) throws IOException {

        return read(new File(bFile).getAbsoluteFile());
    }

    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\out.txt";
       // byte[] read = read(file);

        //for (int i = 0; i < read.length; i++) {
          //  System.out.println((char)read[i]);
        //}

        //InputStream in = new FileInputStream(new File(file));
        InputStream in = new BufferedInputStream(new FileInputStream(new File(file)));

        in.skip(1);
       // System.out.println(skip);

    }


}
