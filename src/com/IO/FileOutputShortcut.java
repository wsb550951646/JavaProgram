package com.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/3117:13
 */
public class FileOutputShortcut {

    static String file = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\out.txt";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("C:\\Users\\sweng.ARCVIDEO\\Desktop\\limitation.properties")));

        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine())!=null){
            out.println(lineCount++ + ":" +s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }


}
