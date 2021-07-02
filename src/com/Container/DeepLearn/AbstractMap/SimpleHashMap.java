package com.Container.DeepLearn.AbstractMap;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2719:38
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {


    static final int SIZE = 997;

    LinkedList<Map.Entry<K,V>>[] buckets = new LinkedList[SIZE];

    //完善SimpleHashMap遍历的过程，创建视图非副本。

    //获取第一个非空bucket的index
    public int firstNotNullBucketIndex(){

        for (int i = 0; i < SIZE; i++) {

            if(buckets[i]!=null)
                return i;
        }

        //整个buckets是空的
        return -1;
    }

    //获取第I-1个bucket的到第一个bucket的Node数 即第I个bucket前有多少个Node数
    public int start(int j){

        int first = firstNotNullBucketIndex();

        int result = 0;
        //先判断j 与 i的大小关系

        //first 大于J ，则没有
        if(first > j)
            return -1;

        //第一个非空的刚好是J 则为0
        if(first == j)
            return 0;


        for(int i = first; i < j ; i++){

            if(buckets[i]!=null)
                result += buckets[i].size();
        }

        return result;

    }

    //获取第I个bucket数有多少个Node节点
    public int end(int j){

        int first = firstNotNullBucketIndex();

        if(first > j)
            return -1;

        //刚第一个非空的就是J 则返回第一个bucket的size
        if (first == j)
            return buckets[first].size();

        //若J > first 返回start() + j个的size

        //return start(j)+buckets[j].size(); 没有考虑buckets[j]为null的情况

        return start(j)+(buckets[j]!=null?buckets[j].size():0);

    }

    public int size(){

        int size = 0;
        for(LinkedList<Map.Entry<K,V>> list:buckets){

            if(list!=null)
                size += list.size();

        }
        return size;
    }

    //模拟put插入方法
    public V put(K key,V val){

        int index = Math.abs(key.hashCode() % SIZE);
        V oldVal = null;

        if(buckets[index]==null){
            buckets[index] =new LinkedList<>();
            System.out.println("新建bucket["+index+"]");
        }
        MapEntry<K, V> entry = new MapEntry<K, V>(key,val);
        LinkedList<Map.Entry<K,V>> bucket = buckets[index];
        boolean found = false;
        for(Map.Entry<K,V> e:bucket){

            if(e.getKey().equals(key)){
                oldVal = e.getValue();
                e.setValue(val);
                found =true;
            }
        }
        if(!found) {
            bucket.add(new MapEntry<>(key, val));
            if(bucket.size()>1) {
                System.out.println("bucket[" + index + "]冲突");
            }
        }
            return oldVal;
    }

    //模拟get插入方法
    public V get(Object key){

        int index = Math.abs(key.hashCode() % SIZE);


        if(buckets[index] == null)
            return null;

        LinkedList<Map.Entry<K,V>> bucket = buckets[index];
        for(Map.Entry<K,V> e:bucket){
            if(e.getKey().equals(key))
                return e.getValue();
        }

        return null;
    }

    public V remove(Object key){

        V oldVal = null;

        oldVal = this.get(key);

        if(oldVal!=null){

            int index = Math.abs(key.hashCode() % SIZE);
            for(Entry<K, V> entry:buckets[index]){

                if(entry.getKey().equals(key) || entry.getKey() == key) {
                    int delete =buckets[index].indexOf(entry);
                    if(delete == -1)
                        return null;
                    oldVal = entry.getValue();
                    buckets[index].remove(delete);
                    break;
                }

            }

        }
        return oldVal;
    }

    public void clear(){

        for (int i = 0; i < SIZE; i++) {
         if(buckets[i]!=null)
             buckets[i].clear();
        }

    }

    @Override
    public Set<K> keySet() {
        return new KeySet();
    }


    @Override
    public Set<Entry<K, V>> entrySet() {


        /*
        Set<Map.Entry<K,V>> entryHashSet = new HashSet<Map.Entry<K,V>>();

        for( LinkedList<Map.Entry<K,V>> bucket:buckets){

            if(bucket==null)
                continue;
            for(Map.Entry<K,V> entry:bucket){
                entryHashSet.add(entry);
            }


        }
         */

        return new EntrySet();
    }

    private class EntrySet extends AbstractSet<Map.Entry<K,V>>{


        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {

                private int index = -1;

                @Override
                public void remove() {

                    for (int i = 0; i < SIZE; i++) {

                        if((start(i) <= index) && (index < end(i)))
                            SimpleHashMap.this.remove( buckets[i].get(index - start(i)).getKey());
                    }
                    if(index!=-1)
                    index--;

                }


                @Override
                public boolean hasNext() {
                    return index < SimpleHashMap.this.size() - 1 ;
                }


                /*
                    仿EntrySet 的next思路：每次next都是按照bucket桶的顺序，再从LinkedList中按顺序获取。
                    所以只要知道了index属于那个bucket桶里，就可以按顺序的活动桶内的Entry元素的key value 返回。
                    则创建了视图，非拷贝。
                */

                @Override
                public Entry<K, V> next() {

                    ++index;
                    //对每个桶遍历
                    for (int i = 0; i < SIZE; i++) {

                        /*
                            这样就把每个bucket的Node的范围限制住了[start(i),end(i))

                            为什么这里
                                index < end(i)  因为第i个的node个数假设是x  则index是 x-1个

                                start(i) <= index 因为第i-1个node数x  则真正index是x-1    而index=x 是bucket[i]的第一个index。
                         */
                        if((start(i) <= index ) && (index < end(i))){

                            return new MapEntry<>(buckets[i].get(index-start(i)).getKey(),
                                                  buckets[i].get(index-start(i)).getValue());
                        }

                    }
                    return null;

                }
            };

        }

        @Override
        public int size() {
            //内部类调用 调用其他类方法
            return SimpleHashMap.this.size();
        }
    }

    private class KeySet extends AbstractSet<K>{

        private int index = -1;

        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                @Override
                public void remove() {

                }

                @Override
                public boolean hasNext() {
                    return index < SimpleHashMap.this.size() - 1;
                }

                @Override
                public K next() {
                    index++;
                    for (int i = 0; i < SIZE; i++) {
                        if((start(i) <= index) && (index < end(i))){
                            return buckets[i].get(index - start(i)).getKey();
                        }
                    }
                    return null;
                }
            };
        }

        @Override
        public int size() {
            return SimpleHashMap.this.size();
        }
    }



    private class MapEntry<K,V> implements Map.Entry<K,V>{

        private K key;
        private V val;

        public MapEntry(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return val;
        }

        @Override
        public V setValue(V value) {
            return val = value;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }


}
