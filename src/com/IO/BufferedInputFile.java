package com.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/3116:35
 */
public class BufferedInputFile {

    public static String read(String fileName) throws IOException{

        BufferedReader in = new BufferedReader(new FileReader(fileName));

        String s;

        List<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        while ((s = in.readLine())!=null){

            stringBuilder.append(s+"\n");

            list.add(s);

        }
            in.close();
        return stringBuilder.toString();
    }



    public static void main(String[] args) throws IOException {

        String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\out2.txt";
        //System.out.println(read("C:\\Users\\sweng.ARCVIDEO\\Desktop\\limitation.properties"));

        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(new File(fileName).getAbsoluteFile()));

        byte[] bytes = new byte[1024];
        int x = 0;
        while( (x = bi.read()) != -1){
            System.out.println((char)x);
        }




    }



}
