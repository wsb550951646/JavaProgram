package com.DeepDesignPattern.DecoratePattern;

import java.io.FileOutputStream;
import java.io.FilterInputStream;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2017:33
 */
public class Client {

    public static void main(String[] args) {

        Drink mokaCoffe = new MokaCoffe();
        Mike mike = new Mike(new MokaCoffe());

        Drink chocolate = new Chocolate(new LuckinCoffe());
        Drink chocolate1 = new Chocolate(new Mike(new LuckinCoffe()));
        Drink chocolate2 =new Mike(new Chocolate(new Mike(new LuckinCoffe())));

        show(chocolate);
        show(chocolate1);
        show(chocolate2);
        show(mokaCoffe);
        show(mike);

    }

    public static void show(Drink drink){

        System.out.println("价格："+drink.cost());
        System.out.println("描述："+drink.getDes());

    }

}
