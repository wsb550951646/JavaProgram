package com.NIO.LockFile;

import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1114:31
 */
public class Lock {

    public static void main(String[] args) throws IOException, InterruptedException {
        final String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";
        RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw");

        FileChannel fc = raf.getChannel();
        FileLock fl = fc.tryLock();

        if (fl.isValid()) {
            System.out.println("get the lock!");

        //测试线程
            new Thread() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(100);
                            FileInputStream fr = new FileInputStream(new File(fileName));
                            int c;
                            while ( (c = fr.read()) != -1) {
                                System.out.println( (char) c);
                            }
                            fr.close();
                            break;
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }.start();

            //模拟其它操作的耗时：比如用notepad打开无法修改。但是用程序来读写此文件都会异常
            raf.write("kingfish(八百里秦川@龙城异客)".getBytes());
            Thread.sleep(5000);

            fl.release();
            System.out.println("release the lock!");
        }
        raf.close();
    }

    @Test
    public void test_1() throws IOException {

        final String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";


        FileOutputStream raf = new FileOutputStream(new File(fileName),false);


        raf.write("121232q".getBytes());

    }

    @Test
    public void test() throws IOException, InterruptedException {

        final String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";


        FileOutputStream raf = new FileOutputStream(new File(fileName),true);

        //FileChannel fc = raf.getChannel();
        //FileLock fl = fc.lock();

       // if (fl.isValid()) {
            System.out.println("get the lock!");

            //测试线程
            new Thread() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(100);
                            FileOutputStream fr = new FileOutputStream(new File(fileName),true);
                            fr.write("a".getBytes());
                            System.out.println("finish!");
                            fr.close();
                            break;
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }.start();

            //模拟其它操作的耗时：比如用notepad打开无法修改。但是用程序来读写此文件都会异常
            raf.write("b".getBytes());
            Thread.sleep(5000);

           // fl.release();
            System.out.println("release the lock!");
       // }
        raf.close();



    }


}
