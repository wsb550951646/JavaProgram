package com.Container.DeepLearn.HashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/29:56
 */
public class CoutedString {

    private static List<String> created = new ArrayList<>();

    private int id = 0;

    private char c;

    private String s = null;


    public CoutedString(String str,char ch) {

        s = str;

        c = ch;

        created.add(str);


        for(String temp : created){

            if(temp.equals(str))
                id++;

        }

    }

    @Override
    public boolean equals(Object o) {

        return o instanceof CoutedString && ((CoutedString)o).s.equals(this.s) && ((CoutedString)o).c == this.c ;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + s.hashCode();
        result = 31 * result + (int)c;
        return result;
    }

    @Override
    public String toString() {
        return "CoutedString{" +
                "id=" + id + "c=" + c +
                ", s='" + s + '\'' + "hashCode:"+this.hashCode()+'}';
    }

    public static void main(String[] args) {


        HashMap<CoutedString, Integer> HashMap = new HashMap<>();

        for (int i = 0; i < 6; i++) {

            HashMap.put(new CoutedString("hi",'a'),i);
        }

        for(Map.Entry<CoutedString,Integer> en : HashMap.entrySet())
            System.out.println(en.getKey()+"-"+en.getValue());


        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {

            map.put(""+1, "v"+i);

        }
        System.out.println(map);


    }

}
