package com.Excutor.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/10/1520:05
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService total = Executors.newFixedThreadPool(1);


        CountDownLatch end = new CountDownLatch(10);
        CountDownLatch begin = new CountDownLatch(1);

        total.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    String player = "选手"+i;
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {

                            System.out.println(player+"准备就绪");
                            try {
                                begin.await();
                                Thread.sleep((long) 4*1000);
                                System.out.println(player+"完成比赛");
                                end.countDown();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }
                    };
                    executorService.submit(runnable);

                }

            }
        });



        System.out.println("比赛开始！！！");
        begin.countDown();

        end.await();
        System.out.println("比赛结束！！！");


    }

}
