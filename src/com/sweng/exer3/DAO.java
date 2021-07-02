package com.sweng.exer3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1710:12
 */
public class DAO<T> {

    private HashMap<String,T> map= new HashMap<>();

    public void save(String id,T entity){
        map.put(id, entity);
    }

    public T get(String id){

        T result = null;
        result = (map.get(id)!=null)? map.get(id):null;

        return result;
    }

/*
        三目运算符：代替赋值语句
        条件表达式不能取代一般的if语句,仅当if语句中内嵌的语句为赋值语句(且两个分支都给同一变量赋值)时才能代替if语句.
 */
    public T update(String id,T entity){

        T result = null;
        result = (map.containsKey(id)) ? map.put(id, entity):null;
        return  result;


    }

    public void delete(String id){

        map.remove(id);

    }

    public List<T> list(){

        ArrayList<T> ts = new ArrayList<>();

        /*
        //第一种遍历方式
        for(Map.Entry e:map.entrySet()){
            ts.add((T)e. getValue());
    bie
        }
        */

        //第二种遍历方式
        for(T t:map.values()){
            ts.add(t);
        }

        return ts;
    }



}
