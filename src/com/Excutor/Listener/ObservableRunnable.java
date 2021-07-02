package com.Excutor.Listener;

import java.util.Observable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1810:19
 */
public class ObservableRunnable extends Observable implements Runnable {

    private String name;

    public ObservableRunnable(String name, ObserverListener listener) {
        this.name = name;
        // 将观察者的对象 注册到观察者中
        super.addObserver(listener);
    }

    private void notifyChange(final RunnableEvent event) {
        // Observable 的类
        super.setChanged();
        super.notifyObservers(event);
    }

    @Override
    public void run() {

        try {
            notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
            System.out.printf("根据 [%s] 查询 \n", this.name);
            Thread.sleep(1000L);
            if (this.name.equals("T3")) {
                // 故意模拟报错
                throw new RuntimeException("故意抛出错误");
            }
            notifyChange(new RunnableEvent(RunnableState.DOWN, Thread.currentThread(), null));
        } catch (Exception e) {
            notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
        }

    }

    enum RunnableState {
        RUNNING, ERROR, DOWN
    }

    static class RunnableEvent {
        private final RunnableState stat;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState stat, Thread thread, Throwable cause) {
            this.stat = stat;
            this.thread = thread;
            this.cause = cause;
        }

        RunnableState getState() {
            return stat;
        }

        public Thread getThread() {
            return thread;
        }

        Throwable getCause() {
            return cause;
        }
    }
}
