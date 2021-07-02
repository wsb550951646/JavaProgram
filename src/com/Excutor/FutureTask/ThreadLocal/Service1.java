package com.Excutor.FutureTask.ThreadLocal;

import com.DeepDesignPattern.FlyweightPattern.User;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/6/2510:39
 */
public class Service1 {
    public void service1(User user){
        System.out.println("service1 get user:"+user.getName());
        ThreadLocalDemo.holder.set(user);
        new Service2().serivce2();

    }
}
