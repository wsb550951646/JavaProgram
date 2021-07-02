package com.Excutor.FutureTask;



/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/6/2417:13
 */
public class InterrutDemo {

    public static void main(String[] args) throws InterruptedException {


        Thread begin = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin");
                for (int i = 0; ; i++) {
                    if (Thread.currentThread().isInterrupted())
                        return;

                    System.out.println(i);
                }
            }
        });

        begin.start();
        Thread.sleep(5000);

        begin.interrupt();
        for (int i = 0; i < 50; i++) {
            System.out.println("----------------结束-------------");
        }



    }

}
