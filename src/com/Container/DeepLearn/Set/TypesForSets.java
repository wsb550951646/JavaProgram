package com.Container.DeepLearn.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2714:07
 */
public class TypesForSets {

    static <T> Set<T> fill(Set<T>set, Class<T> type){

        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        }catch (Exception e){
            throw new RuntimeException();
        }

        return set;
    }

    static <T> void testThrid(Set<T> set,Class<T> type){

        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);

    }
    static <T> void testduplicate(Set<T> set,Class<T> type) throws Exception {

        set.add(type.getConstructor(int.class).newInstance(1));
        set.add(type.getConstructor(int.class).newInstance(1));
        System.out.println(set);

    }



    public static void main(String[] args) throws Exception {

        testThrid(new HashSet<HashType>(), HashType.class);
        testThrid(new TreeSet<TreeType>(), TreeType.class);
        testThrid(new LinkedHashSet<HashType>(), HashType.class);

        testduplicate(new HashSet<HashType>(), HashType.class);

        testduplicate(new HashSet<Integer>(), Integer.class);


    }

}
