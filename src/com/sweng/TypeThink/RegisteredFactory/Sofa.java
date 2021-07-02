package com.sweng.TypeThink.RegisteredFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/299:59
 */
public class Sofa extends FactoryAssemble{

    public static class Factory implements com.sweng.TypeThink.RegisteredFactory.Factory<Sofa>{

        @Override
        public Sofa Create() {
            return new Sofa();
        }
    }

}
