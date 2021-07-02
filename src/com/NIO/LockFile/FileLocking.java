package com.NIO.LockFile;

import com.Container.List.Student;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1111:16
 */
public class FileLocking {

    @Test
    public void test(){

        Student student = new Student(1,"1");
        Student student1 = new Student(1,"1");
        System.out.println("=="+(student==student1));
        System.out.println("equals"+(student.equals(student1)));

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        final String fileName ="C:\\Users\\sweng.ARCVIDEO\\Desktop\\test33.txt";

        ArrayList<Runnable> objects = new ArrayList<>();
        for ( int x = 0; x < 5 ; x++) {

            final int i = x;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    Random random = new Random();
                    random.nextInt(5);
                    FileOutputStream out = null;
                    FileLock fileLock = null;
                    try {
                        out = new FileOutputStream(new File(fileName).getAbsoluteFile(), true);
                        //fileLock = out.getChannel().tryLock();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    try {

                        while (true){
                            TimeUnit.MILLISECONDS.sleep(100*random.nextInt());
                            System.out.println("Lock:"+i);
                            out.write(("test:"+i).getBytes());
                            System.out.println("Release Lock"+i);
                            //fileLock.release();
                            break;
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }  finally {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }




                }
            };
            objects.add(runnable);
        }


        for(Runnable r:objects){
            r.run();
        }




    }

}
