package com.Excutor.Listener.MyRunnableListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1811:19
 *
 *
 * 总结： 该监听者模式的使用场景：
 *
 * 1. 无侵入性去使用接口的多样性：
 *
 *      因为在TaskRunnable中 ，调用了fireStatusChanger() - > 会去调用所有的listener 去执行OnStatusChanged()方法
 *
 *      又因为onStatusChanged()方法，是通过RunnableStatusListener (Interface接口)去实现的
 *
 *      新的的类XXX，实现了RunableStatusListener，然后TaskRunnable成为XXX的监听对象。 即 taskRunable.addListener(XXX);
 *
 *      XXX可以实现不同的OnStatusChanged()方法。
 *
 *
 *
 */
public class TaskRunnable implements Runnable {

    private String ThreadName;

    public TaskRunnable(String threadName) {
        ThreadName = threadName;
    }

    //添加监听者
    public void addListener(RunnableStatusListener listener) {
        listeners.add(listener);
    }

    //触发监听
    public void fireStatusChanger(String status) {
        for(RunnableStatusListener listener : listeners){
            listener.onstatusChanged(this.ThreadName,status);
        }
    }

    //被监视者，含有多个监听者的对象属性
    private List<RunnableStatusListener> listeners = new ArrayList<>();

    @Override
    public void run() {

        System.out.println("线程名称："+ThreadName +" 正在运行中");
        this.fireStatusChanger("Running");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(ThreadName.equals("异常任务")){
            try {
                throw new Exception("故意抛出异常任务");
            } catch (Exception e) {
                this.fireStatusChanger("Error");
                e.printStackTrace();
                return;
            }
        }
        this.fireStatusChanger("Ending");
    }
}
