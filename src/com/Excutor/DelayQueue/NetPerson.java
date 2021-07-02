package com.Excutor.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/2610:27
 */
public class NetPerson implements Delayed {

    //
    private String ID;

    private String name;

    //支付金额 相当于上网时间
    private long playTime;

    public NetPerson(String ID, String name, long playTime) {
        this.ID = ID;
        this.name = name;
        this.playTime = playTime*1000+System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return this.playTime - System.currentTimeMillis();
    }

    //队列取出的优先级 是依靠比较演示长度取出的
    @Override
    public int compareTo(Delayed o) {
        NetPerson person = (NetPerson)o;
        return this.getDelay(TimeUnit.SECONDS) - person.getDelay(TimeUnit.SECONDS) >0?1:0;
    }
}
