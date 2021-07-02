package com.sweng.TypeThink.RegisteredFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/299:59
 */
public class Table extends FactoryAssemble {

    public static class Factory implements com.sweng.TypeThink.RegisteredFactory.Factory<Table>{


        @Override
        public Table Create() {
            return new Table();
        }
    }

}
