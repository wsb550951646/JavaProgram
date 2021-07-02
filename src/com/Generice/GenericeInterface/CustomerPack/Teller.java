package com.Generice.GenericeInterface.CustomerPack;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2114:38
 */
public class Teller {

    private static Integer count = 0;
    private final long id = count++;

    public Teller() {
    }

    public String toString(){

        return "teller:"+id;
    }

    public static generator<Teller> Generator(){

        return new generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };

    }

}
