package com.Excutor.FutureTask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/6/2415:01
 */
public class CallableDemo {

    static class TaskWithResult implements Callable<String> {
        private Integer id;

        public TaskWithResult(Integer id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            //System.out.println("result of TaskWithResult id :"+id);
            return "result of TaskWithResult id :"+id;
        }
    }
    @Test
    public void testDeamon() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread damon = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        System.out.println("this is deamon");
                    } catch (InterruptedException e) {

                    }
                }
            });

            //damon.setDaemon(true);
            damon.start();
        }

        System.out.println("main");
        Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        /**
         * 自定义线程池的队列
         *
         * 1. ArrayBlockingQueue 有限队列，如果队列中的任务满了，使用默认拒绝策略 RejectedExecutionHandler
         *
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。注：默认策略！！！！！！
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
         */

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

        //默认AbortPolicy策略，可以选择其他 DiscardPolicy 抛弃任务但不出异常
        //threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        //自定义策略
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if(executor.isShutdown())
                    return;
                System.out.println("this is reject run");
                r.run();

            }
        });


        ArrayList<Future<String>> results = new ArrayList<>();


        //submit 去返回的是一个Future. 通过Future类去get信息，设置超时时间
        for (int i = 0; i < 100; i++) {
            results.add(threadPoolExecutor.submit(new TaskWithResult(i)));
        }

        for(Future<String> each:results){
            String s = each.get(1000, TimeUnit.MILLISECONDS);
            System.out.println(s);
        }
        threadPoolExecutor.shutdown();
    }

}
