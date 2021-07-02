package com.Generice.GenericeInterface.CustomerPack;

import java.util.Collection;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2114:40
 */
public class Generators {

    public static <T>  Collection<T> fill(generator<T> generator,Collection<T> collection,int n){

        for (int i = 0; i < n ; i++) {
            T next = generator.next();
            collection.add(next);
        }
       return collection;
    }

}
