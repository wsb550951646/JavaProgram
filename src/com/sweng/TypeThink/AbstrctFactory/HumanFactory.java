package com.sweng.TypeThink.AbstrctFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2911:05
 */
public class HumanFactory extends AbstrctFactory {

    public static List<Class<? extends Human>> humans = new ArrayList<>();
    private Random rand = new Random(10);


    static {
        humans.add(YellowHuman.class);
        humans.add(WhiteHuman.class);
    }

    @Override
    public <T extends Human> T CreateHuman(Class<T> t) {

        Human human = null;

        try {
            human = (T)Class.forName(t.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return (T)human;


    }

    @Override
    public <T extends Human> T CreateRandomHuman() {

        int n = rand.nextInt(humans.size());

        try {
            return (T)humans.get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        HumanFactory humanFactory = new HumanFactory();

        Human human = humanFactory.CreateHuman(WhiteHuman.class);
       // human.talk();

        Human human2 = humanFactory.CreateHuman(YellowHuman.class);
        //human2.talk();

        for (int i = 0; i < 22; i++) {
            humanFactory.CreateRandomHuman().talk();
        }


    }
}
