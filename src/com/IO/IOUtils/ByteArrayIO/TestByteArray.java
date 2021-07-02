package com.IO.IOUtils.ByteArrayIO;

import java.io.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1215:07
 */
public class TestByteArray {

    public static void main(String[] args) throws IOException {

       // byte[] result = TestByteArray.TestBin();

        //TestByteArray.TestBis(result);

        TestByteArray.testBout();

    }


    public static void TestBis(byte[] fileBytes) throws IOException {

        int len = -1;
        String fileName2 = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\test22.txt";
        FileOutputStream fout = new FileOutputStream(new File(fileName2).getAbsoluteFile());
        ByteArrayInputStream bin = new ByteArrayInputStream(fileBytes);

        byte[] b = new byte[1024];

        while ((len=bin.read(b))!=-1){
            fout.write(b, 0, len);
        }
        fout.close();
        bin.close();

    }

    public static byte[] TestBin() throws IOException {
        String fileName2 = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";
        FileInputStream fin = new FileInputStream(new File(fileName2).getAbsoluteFile());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        int len = -1;
        byte[] bytes = new byte[2048];
        while ((len=fin.read(bytes))!=-1){
            bout.write(bytes, 0, len);

    }
        fin.close();
        return bout.toByteArray();

    }

    public static void testBout() throws IOException {

        String fileName2 = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";
        String fileName = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\test22.txt";
        FileInputStream fin = new FileInputStream(new File(fileName2).getAbsoluteFile());
        FileOutputStream fout = new FileOutputStream(new File(fileName).getAbsoluteFile());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();


        int len = -1;
        byte[] bytes = new byte[2048];
        while ((len=fin.read(bytes))!=-1){
            bout.write(bytes, 0, len);
        }
        bout.writeTo(fout);
        fin.close();
        fout.close();
        bout.close();

    }



}
