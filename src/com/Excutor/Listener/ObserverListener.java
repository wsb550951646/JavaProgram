package com.Excutor.Listener;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1810:16
 */
public class ObserverListener implements Observer {

    //避免多线程竞争
    private static final Object Lock = new Object();

    @Override
    public void update(Observable observable, Object runnableEvent) {

        synchronized (Lock) {

            ObservableRunnable.RunnableEvent event = (ObservableRunnable.RunnableEvent) runnableEvent;
            if (event != null) {
                if (event.getCause() != null) {
                    System.out.println("The Runnable [" + event.getThread().getName() + "] process failed and state is " + event.getState().name());
                    event.getCause().printStackTrace();
                } else {
                    System.out.println("The Runnable [" + event.getThread().getName() + "] data changed and state is " + event.getState().name());
                }
            }

        }

    }
}
