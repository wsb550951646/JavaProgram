package com.Container.DeepLearn.AbstractMap;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2716:39
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> vals = new ArrayList<>();


    public V put(K key,V val){
        V oldVal = get(key);
        if(keys.contains(key)){
            vals.set(keys.indexOf(key),val);
        }else {
            keys.add(key);
            vals.add(val);
        }
        return oldVal;
    }

    public V get(Object key){
        V val = null;

        if(keys.contains(key))
        val = vals.get(keys.indexOf(key));

        return val;
    }

    public List<K> getKeys() {
        return keys;
    }


    public List<V> getVals() {
        return vals;
    }


    @Override
    public Set<Map.Entry<K, V>> entrySet() {

            return new EntrySet();
    }

    private class EntrySet<K,V> extends AbstractSet<Map.Entry<K,V>>{


        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
                //视图，会影响原来的映射表
            return new Iterator<Entry<K, V>>() {

                private int index = -1;

                /* 副本：不会对原始映射表进行修改。
                  Set<Map.Entry<K, V>> entries = new HashSet<>();
                  for (int i = 0; i < keys.size(); i++) {
                    entries.add(new MapEntry<>(keys.get(i), vals.get(i)));
                   }
                  return entries;
                 */

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public Entry<K, V> next() {
                    ++index;
                    return new MapEntry(keys.get(index),vals.get(index));
                }

                @Override
                public void remove() {
                    keys.remove(index);
                    vals.remove(index);
                    index--;

                }
            };
        }

        @Override
        public int size() {
            return keys.size();
        }
    }



    private  class MapEntry<K,V> implements Map.Entry<K,V>{

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;

            if (key != null ? !key.equals(mapEntry.key) : mapEntry.key != null) return false;
            return val != null ? val.equals(mapEntry.val) : mapEntry.val == null;

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (val != null ? val.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "MapEntry{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }


}
