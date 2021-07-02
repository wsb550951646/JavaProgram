package com.IO.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/614:05
 */
public class TextFile extends ArrayList<String> {

    public TextFile(String fileName, String splitter) throws FileNotFoundException {

        super(Arrays.asList(read(fileName).split(splitter)));

        if(get(0).equals(""))
            remove(0);

    }

    public TextFile(String fileName) throws FileNotFoundException {

        this(fileName,"\n");

    }

    public static String read(String fileName) throws FileNotFoundException {

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));

        try {


            try {
                String s;
                while (((s = in.readLine())!= null)){
                 stringBuilder.append(s);
                 stringBuilder.append("\n");
                }

            } finally {
                in.close();
            }
        }catch (IOException e) {
            throw new RuntimeException();
        }

        return stringBuilder.toString();
    }



    public static void write(String fileName, String text){

        try {

            PrintWriter pout = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                pout.print(text);
            } finally {
                pout.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public void write(String fileName){

        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());

            try {
                for (String item : this) {
                    out.println(item);
                }
            }finally {
                out.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws FileNotFoundException {
        String f = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\out.txt";
        String f1 = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\out1.txt";
        String f2 = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\out2.txt";

        String file = read(f);

        write(f1,file);

        TextFile textFile = new TextFile(f1);
        textFile.write(f2);

        TreeSet<String> words = new TreeSet<String>(new TextFile(f2, "="));

        for(String s:words){
            System.out.println(s);
        }


    }






}
