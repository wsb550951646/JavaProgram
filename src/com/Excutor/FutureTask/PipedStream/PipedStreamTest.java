package com.Excutor.FutureTask.PipedStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/6/2515:39
 */
public class PipedStreamTest {


    public static void main(String[] args) {

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Producer producer = new Producer(pos);
        Consumer consumer = new Consumer(pis);

        Thread p1 = new Thread(producer, "生1");
        Thread p2 = new Thread(producer, "生2");
        Thread p3 = new Thread(producer, "生3");
        Thread p4 = new Thread(producer, "生4");

        new

    }


    private static class Producer implements Runnable{

        private PipedOutputStream pos;

        public Producer(PipedOutputStream p) {
            pos = p;
        }

        @Override
        public void run() {

            try {
                for (int i = 0; i < 10; i++) {
                    pos.write(("This is a test message,messageId=" + i + "\n").getBytes());
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable{
        private PipedInputStream pis;

        public Consumer(PipedInputStream p) {
            pis = p;
        }

        public PipedInputStream getPipedInputStream(){
            return pis;
        }
        @Override
        public void run() {
            int len = -1;
            byte[] buffer = new byte[1024];
            try {
                while((len = pis.read(buffer))!=-1){
                    System.out.println(new String(buffer,0,len));
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
