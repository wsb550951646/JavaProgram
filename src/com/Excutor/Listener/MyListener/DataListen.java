package com.Excutor.Listener.MyListener;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1810:40
 */
public class DataListen implements IDataListen {

    @Override
    public void updated(Object event, Object msg) {
        System.out.println("监听器知道了数据变化 消息:"+msg + "event："+((DataManager.RunnableEvent)event).getState());
    }
}
