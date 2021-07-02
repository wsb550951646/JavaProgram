package com.Container.DeepLearn.AbstractMap;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2616:55
 */
public class Coutries {

    public static String[][] DATA = {
            {"SOUTH AFRICA", "Cape Town"}, {"SUDAN", "Khartoum"},
            // Asia
            {"CHINA", "Beijing"}, {"JAPAN", "Tokyo"}, {"SOUTH KOREA", "Seoul"},
            // Australia and Oceania
            {"AUSTRALIA", "Canberra"}, {"NEW ZEALAND", "Wellington"},
            // Europe
            {"UNITED KINGDOM", "London"}, {"FRANCE", "Paris"}, {"GERMANY", "Berlin"}, {"ITALY", "Rome"},
            {"SPAIN", "Madrid"}
    };

    public FlyWeightMap getSingle(){
        return new FlyWeightMap();
    }

    public FlyWeightMap getSingle(int size){
        return new FlyWeightMap(size);
    }

    public static class FlyWeightMap extends AbstractMap<String,String>{

        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

        private int dataLength;


        public FlyWeightMap(){
            this.dataLength = 0;
        }

        public FlyWeightMap(int dataLength) {
            this.dataLength = dataLength;
        }

        //继承 extends AbstractMap<String,String> 必须重写entrySet()方法
        @Override
        public Set<Map.Entry<String, String>> entrySet() {

            if(dataLength > 0)
                return new EntrySet(dataLength);

            return entries;
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<String,String>>{

        private int size;


        public EntrySet(int size) {
            this.size = (size < 0) ? 0 : ((size > DATA.length) ? DATA.length : size);
        }


        //extends继承AbstractSet 必须重写  Iterator()  size()方法
        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            return new Iterator<Map.Entry<String, String>>() {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size -1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }


    private static class Entry implements Map.Entry<String,String>{

        int index;

        //继承Map.Entry 重写hashCode  equals
        @Override
        public int hashCode() {
            return DATA[index][0].hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return DATA[index][0].equals(obj);
        }

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public String getKey() {
            return DATA[index][0];
        }

        @Override
        public String getValue() {
            return DATA[index][1];
        }

        @Override
        public String setValue(String value) {
            throw  new UnsupportedOperationException();
        }
    }

    public static Map<String,String> capitals(){

        return selectAll();
    }

    private static Map<String,String> selectAll(){

        return new FlyWeightMap();

    }

    public static Map<String,String> capitals(int size){

        return select(size);
    }

    private static Map<String,String> select(int size){
        return new FlyWeightMap(size);
    }

}
