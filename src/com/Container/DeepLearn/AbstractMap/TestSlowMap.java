package com.Container.DeepLearn.AbstractMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2716:58
 */
public class TestSlowMap {

    public static void main(String[] args) {

        SlowMap<String, String> map = new SlowMap<>();
        map.putAll(Coutries.capitals(12));
        System.out.println(map);

        for(Map.Entry<String,String> e:map.entrySet()){
            System.out.println(e.getKey()+"-"+e.getValue());
        }
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.clear();
        System.out.println("clear："+map.isEmpty()+entries.isEmpty());

        System.out.println("---------------------------------");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.putAll(Coutries.capitals(12));
        Set<Map.Entry<String, String>> entries1 = hashMap.entrySet();
        entries1.clear();
        System.out.println("clear2:"+hashMap.isEmpty());
        System.out.println("clear2"+hashMap);

    }

}
