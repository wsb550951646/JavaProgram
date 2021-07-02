package com.Excutor.FutureTask.ThreadLocal;

import com.DeepDesignPattern.FlyweightPattern.User;


/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/6/2510:12
 *
 *
 * 使用场景一：
 * 每个线程内需要保存类似于全局变量的信息
 *（例如在拦截器中获取的用户信息），可以让不同方法直接使用，
 * 避免参数传递的麻烦却不想被多线程共享（因为不同线程获取到的用户信息不一样）。
 *
 * hreadLocal 保存一些业务内容（用户权限信息、从用户系统获取到的用户名、用户ID 等），
 * 这些信息在同一个线程内相同，但是不同的线程使用的业务内容是不相同的
 *
 * ThreadLocal 实例的 get() 方法取得自己 set 过的那个对象，避免了将这个对象（如 user 对象）作为参数传递的麻烦。
 * 当一个请求进来的时候，一个线程会负责执行这个请求，然后这个请求就会依次调用service-1()、service-2()、service-3()、service-4()，这4个方法可能是分布在不同的类中的。
 *
 */
public class ThreadLocalDemo {

    public static ThreadLocal<User> holder = new ThreadLocal<>();

    public static void main(String[] args) {

            for (int i = 0; i<5 ; i++) {
                final int ix = i;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        User sweng = new User("sweng" + ix);
                        new Service1().service1(sweng);
                    }
                }).start();
            }
    }

}
