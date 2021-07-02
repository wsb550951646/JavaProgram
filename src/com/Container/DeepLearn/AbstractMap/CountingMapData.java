package com.Container.DeepLearn.AbstractMap;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2711:01
 */
public class CountingMapData extends AbstractMap<Integer,String> {

    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    private static Set<Map.Entry<Integer,String>> entries = new EntrySet(chars.length);

    public CountingMapData(int size) {
        if(size<0)
            this.size = 0;
        this.size = size;
    }

    public CountingMapData() {
        size = 0;
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        if(size==0)
            return entries;

        return new EntrySet(size);

        /*
            也可以直接使用LinkedHashSet等成型的容器，不同建立自己的EntrySet去继承AbstractSet
              Set<Map.Entry<Integer,String>> en = new LinkedHashSet<Map.Entry<Integer, String>>();

              for(int i=0;i<size;i++){
                en.add(new Entry(i));
              }
              return en;

         */


    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer,String>>{

        private int size;


        public EntrySet(int size){
            this.size = size;
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {

                Entry entry =new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return chars.length;
        }
    }

    private static class Entry implements Map.Entry<Integer,String>{

        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    public static Map<Integer,String> map(int size){
        return new CountingMapData(size);
    }

    public static Map<Integer,String> map(){
        return new CountingMapData();
    }


}
