package com.Excutor.Listener;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/1810:28
 */
public class Test {

    public static void main(String[] args) {
        ObserverListener listener = new ObserverListener();
        List<String> names = Arrays.asList("T1", "T2", "T3");
        for (String name : names) {
            Thread thread = new Thread(new ObservableRunnable(name, listener));
            thread.start();
        }
    }

}
