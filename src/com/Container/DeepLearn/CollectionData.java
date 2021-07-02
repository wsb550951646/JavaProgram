package com.Container.DeepLearn;

import com.Generice.GenericeInterface.CustomerPack.Generators;
import sun.nio.cs.Surrogate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2610:08
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator,int quantity){
        return new CollectionData(generator,quantity);
    }

    public static void main(String[] args) {

        Gover gover = new Gover();

        CollectionData<String> list = list(gover, 10);

        Set<String> stringSet = new LinkedHashSet<String>(list);

        System.out.println(stringSet);

        System.out.println(list);


    }

}
