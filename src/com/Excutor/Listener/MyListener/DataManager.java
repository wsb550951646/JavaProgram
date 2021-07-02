package com.Excutor.Listener.MyListener;

import com.Excutor.Listener.ObservableRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1810:41
 */
public class DataManager {

    private List<IDataListen> listenList = new ArrayList<>();

    public void notifyListen(Object event , Object msg){
        for(IDataListen dataListen : listenList){
            dataListen.updated(event,msg);
        }
    }

    public void addListen(IDataListen iDataListen){
        listenList.add(iDataListen);
    }

    public void updateData(Object event , Object msg){
        this.notifyListen(event,msg);
    }
    enum RunnableState {
        RUNNING, ERROR, DOWN
    }

    static class RunnableEvent {
        private final RunnableState stat;

        public RunnableEvent(RunnableState stat) {
            this.stat = stat;
        }

        RunnableState getState() {
            return stat;
        }
    }


    public static void main(String[] args) {

        DataManager dataManager = new DataManager();

        DataListen dataListen = new DataListen();
        DataListen dataListen2 = new DataListen();
        dataManager.addListen(dataListen);
        dataManager.addListen(dataListen2);

        dataManager.updateData(new RunnableEvent(RunnableState.RUNNING), "aaa");


    }

}
