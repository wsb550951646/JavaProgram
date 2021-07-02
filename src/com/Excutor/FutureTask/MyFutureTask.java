package com.Excutor.FutureTask;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/12/115:48
 *
 *
 * FutureTask 主要就是实现了 Runnable 和 Future<T> 接口
 *
 * Runnable： 去执行run方法多线程， 但是返回值只有void
 *
 * Future： 可以对执行的结果进行查询，等操作
 *
 * 实现的方法：
 *
 *  重写Run方法， 使线程结果返回给 result。 有结果后唤醒其他线程
 *
 *  重写get方法， 去获取result结果，若无结果则堵塞。
 *
 *
 */
public class MyFutureTask<T> implements Runnable, Future<T> {

    private Callable<T> callable;

    private T result  = null;

    public MyFutureTask(Callable<T> callable) {
        this.callable = callable;
    }


    @Override
    public void run() {

        T temp = null;
        try {
            temp = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized (this){
            result = temp;
            this.notifyAll();
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {

        if(result!=null)
            return result;

        System.out.println("等待结果执行完成");
        synchronized (this) {
            wait();
        }
        return result;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                long result = 0;
                for (int i = 0; i < 8000; i++) {
                    result = i + result;
                }
                Thread.sleep(5000);
                return result;
            }
        };


        MyFutureTask<Long> futureTask = new MyFutureTask<>(callable);
        new Thread(futureTask).start();

        System.out.println("主线程等待");
        Long result = futureTask.get();

        System.out.println("线程结果:"+result);

    }
}
