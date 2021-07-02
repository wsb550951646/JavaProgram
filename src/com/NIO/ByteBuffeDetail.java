package com.NIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/811:20
 */
public class ByteBuffeDetail {

    @Test
    public void test() throws IOException {

        byte[] b = {1,2,3};
        String fileName2 ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test.txt";
        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName2).getAbsoluteFile());
        FileChannel outchannel = fileOutputStream.getChannel();



        System.out.println("before:"+byteBuffer.position());
        System.out.println("before limit:"+byteBuffer.limit());

        outchannel.write(byteBuffer);

        System.out.println("after:"+byteBuffer.position());
        System.out.println("after limit:"+byteBuffer.limit());


    }


    //通道本地文件的几种方法

    public static void main(String[] args) throws IOException {


        //1. 通过 FileInputStream  FileOutputStream   RandomAccessStream 调用getChannel()方法
        String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test22.txt";
        String fileName2 ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        FileInputStream fileInputStream = new FileInputStream(new File(fileName).getAbsoluteFile());
        FileChannel channel = fileInputStream.getChannel();

        //将读到byteBuffer缓冲区中
        int read = channel.read(byteBuffer);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.hasRemaining());


        //写到
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName2).getAbsoluteFile());
        FileChannel outchannel = fileOutputStream.getChannel();

        //切换写模式，实质将 limit = position;  position = 0;  mark = -1;
        int n = 0;
        while ( (n = channel.read(byteBuffer))!=-1){
            byteBuffer.flip();
            outchannel.write(byteBuffer);
            //将postion归为0 因为write的时候，postion不停增加
            byteBuffer.clear();
        }
    }

    @Test
    public void testMap() throws IOException {

        String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test22.txt";
        String fileName2 ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";
        FileChannel inputChannel = FileChannel.open(Paths.get(fileName), StandardOpenOption.READ);

        FileChannel outputChannel = FileChannel.open(Paths.get(fileName2), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);


        MappedByteBuffer inmap = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputChannel.size());
        MappedByteBuffer outmap = outputChannel.map(FileChannel.MapMode.READ_WRITE, 0, inputChannel.size());

        byte[] bytes = new byte[inmap.limit()];

        inmap.get(bytes);
        //ByteBuffer
        outmap.put(bytes);

        inputChannel.close();
        outputChannel.close();
    }


}
