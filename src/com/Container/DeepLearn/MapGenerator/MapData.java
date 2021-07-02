package com.Container.DeepLearn.MapGenerator;

import com.Container.DeepLearn.Generator;

import java.util.LinkedHashMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2610:34
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {

    public MapData(Generator<Pair<K,V>> gen,int qulity){
        for (int i = 0; i < qulity; i++) {
            Pair<K,V> pair = gen.next();
            put(pair.getKey(),pair.getVal());
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quality){
        return new MapData<>(gen,quality);
    }

    
    public MapData(Generator<K> key,Generator<V> val,int qulity){

        for (int i = 0; i < qulity; i++) {
            put(key.next(), val.next());
        }
        
    }

    public static <K,V> MapData<K,V> map(Generator<K> key,Generator<V> val,int quality){
        return new MapData<>(key, val, quality);
    }


}
