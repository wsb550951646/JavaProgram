package com.Container.DeepLearn.AbstractMap;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2816:06
 */
public class TsetSimpleHashMap {
    public static void main(String[] args) {

        SimpleHashMap<Integer, String> maps = new SimpleHashMap<>();
        maps.putAll(CountingMapData.map(10));
       // System.out.println(maps);
        System.out.println(maps.size());
        for(Map.Entry<Integer,String> e:maps.entrySet()){
            System.out.println(e.getKey()+"--"+e.getValue());
        }
        maps.remove(1);
        System.out.println(maps);

        for(Map.Entry<Integer,String> e:maps.entrySet()){

            System.out.println(e.getKey()+"--"+e.getValue());


        }
        maps.entrySet().clear();
        System.out.println(maps);


    }

    @Test
    public void test(){


        LinkedList<Map.Entry<Integer, String>> entries = new LinkedList<>();

    }

}
