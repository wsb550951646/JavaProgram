package com.sweng.TypeThink.AbstrctFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2911:00
 */
public abstract class AbstrctFactory {

    public abstract <T extends Human> T CreateHuman(Class<T> t);   //是泛型抽象方法  泛型方法中在返回值与public中间有 <...> 的定义 定义了T的范围

    public abstract <T extends Human> T CreateRandomHuman();

}
