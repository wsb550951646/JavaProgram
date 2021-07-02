package com.Container.DeepLearn.AbstractMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2619:17
 */
public class TestCoutries {

    @Test
    public void TestCoutingMap(){

        HashMap hashMap = new HashMap(CountingMapData.map(60));
        System.out.println(hashMap);
    }

    public static void main(String[] args) {

        HashMap hashMap = new HashMap(Coutries.capitals());

        System.out.println(hashMap);

        System.out.println(new HashMap(Coutries.capitals(3)));

        Coutries coutries = new Coutries();

        Coutries.FlyWeightMap map = coutries.getSingle();

        HashMap result = new HashMap<String,String>();

        //循环源码
        for(Map.Entry<String,String> t:map.entrySet()){
            System.out.println("key:"+t.getKey()+" val:"+t.getValue());
            if(t.getKey().startsWith("C"))
                result.put(t.getKey(),t.getValue());
        }

        System.out.println(result);



    }

}
