package com.Excutor.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/12/113:44
 *
 * 继承 RecursiveTaks 类 去实现
 *
 * compute 每次执行 该类都会计算，是否需要拆分任务
 *
 * ForkJoinPool pool = new ForkJoinPool(); 线程池
 * pool.invoke() 是执行任务
 *
 * sumNumberTask.join() 是去返回该执行的结果
 *
 */
public class ForkJoinThread {

    private static final int THRRSHOLD = 5000;

    private static final int MIN = 0;

    private static final int MAX = 10000000;

    private static class SumNumberTask extends RecursiveTask<Long> {

        private int start;
        private int end;

        public SumNumberTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if (end - start < THRRSHOLD) {
                try {
                    return sumBatch(start, end);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                int middle = (start + end) / 2;
                System.out.println("拆分任务:"+middle);
                SumNumberTask leftTask = new SumNumberTask(start, middle);
                SumNumberTask rightTask = new SumNumberTask(middle + 1, end);
                invokeAll(leftTask, rightTask);
                Long leftJoin = leftTask.join();
                Long rightJoin = rightTask.join();
                return leftJoin + rightJoin;
            }
        }

        public static void main(String[] args) {
            ForkJoinPool pool = new ForkJoinPool();
            long start = System.currentTimeMillis();
            int recordMin = MIN;
            int recordMax = MAX;
            SumNumberTask sumNumberTask = new SumNumberTask(recordMin, recordMax);
            pool.invoke(sumNumberTask);
            System.out.println("Task is Running");
            Long result = sumNumberTask.join();
            System.out.println("The result is " + result + " spend Time:" + (System.currentTimeMillis() - start) + " ms");

        }

        private static long sumBatch(int fromId, int toId) throws InterruptedException {

            long sum = 0;
            Thread.sleep(15);
            for (int i = fromId; i < toId; i++) {
                sum = sum + i;
            }
            return sum;

        }
    }
}


