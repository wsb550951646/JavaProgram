package com.Excutor.DelayQueue;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/2610:33
 */
public class InternetBar implements Runnable {

    private DelayQueue<NetPerson> dq = new DelayQueue<NetPerson>();

    public void startNet(String id,String name,Integer money){

        NetPerson person = new NetPerson(id, name, money);
        System.out.println("上机 名字:"+name);
        dq.add(person);
    }

    public void endTime(NetPerson person){
        System.out.println("下机 name:"+person.getName());
    }

    @Override
    public void run() {

        while (true){

            try {
                NetPerson take = dq.take();
                endTime(take);
            } catch (InterruptedException e) {


            }

        }


    }

    public static void main(String[] args) {


        HashMap<String, List<String>> stringStringHashMap = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        stringStringHashMap.put("1",strings);

        List<String> list = stringStringHashMap.get("1");
        list.add("test2");

        for(Map.Entry<String,List<String>> t : stringStringHashMap.entrySet()){
            System.out.println(t.getKey());
            List<String> value = t.getValue();
            for(String x:value){
                System.out.println(x);
            }
        }

/*
        InternetBar internetBar = new InternetBar();

        internetBar.startNet("001", "NO.1",3);
        internetBar.startNet("002", "NO.2",5);
        internetBar.startNet("003", "NO.3",7);

        //ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute(internetBar);

        Thread thread = new Thread(internetBar);
        thread.start();
*/
    }
}
