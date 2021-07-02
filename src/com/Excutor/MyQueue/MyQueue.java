package com.Excutor.MyQueue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/269:44
 */
public class MyQueue {

    //元素集合
    private LinkedList<String> list = new LinkedList<>();

    //计数器
    private AtomicInteger count = new AtomicInteger();

    //存储容量
    private final Integer MIN_SIZE = 0;
    private final Integer MAX_SIZE;

    public MyQueue(Integer max) {
        MAX_SIZE = max;
    }

    //锁用作唤醒作用
    private Object lock = new Object();

    public void put(String str) {
        synchronized (lock) {
            while (count.get() == this.MAX_SIZE) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.add(str);
            count.incrementAndGet();
            System.out.println("入队列 str:" + str + " 长度:" + list.size());
            lock.notify();  // 唤醒其他线程去取元素
        }
    }

    public String take(){
        String result = null;
        synchronized (lock) {
            while (count.get() == this.MIN_SIZE){
                try {
                    lock.wait();
                } catch (InterruptedException e) {

                }
            }

            result = list.removeFirst();
            count.decrementAndGet();
            System.out.println("出队列 str:"+result+" 长度:"+list.size());
            lock.notify(); //唤醒满队列 去放
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        MyQueue myQueue = new MyQueue(5);
        myQueue.put("1");
        myQueue.put("2");
        myQueue.put("3");
        myQueue.put("4");
        myQueue.put("5");

        Thread thread = new Thread(() -> {
            myQueue.put("7");
            myQueue.put("8");
        });

        Thread thread2 = new Thread(() -> {
            String take = myQueue.take();
            String take1 = myQueue.take();
        });

        thread.start();

        Thread.sleep(2000);

        thread2.start();


    }

}
