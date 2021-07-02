package com.sweng.TypeThink.RegisteredFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/299:59
 */
public class Stool extends FactoryAssemble{

    public static class Factory implements com.sweng.TypeThink.RegisteredFactory.Factory<Stool>{

        @Override
        public Stool Create() {
            return new Stool();
        }
    }

}
