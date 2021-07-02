package com.Excutor.FutureTask.ThreadLocal;

import com.DeepDesignPattern.FlyweightPattern.User;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/6/2510:40
 */
public class Service2 {
    public void serivce2(){
        User user = ThreadLocalDemo.holder.get();
        System.out.println("service2 get user:"+user.getName());
        ThreadLocalDemo.holder.remove();
    }
}
