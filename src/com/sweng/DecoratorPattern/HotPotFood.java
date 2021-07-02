package com.sweng.DecoratorPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/5/910:18
 */
public class HotPotFood implements food{

    public HotPotFood() {
    }

    @Override
    public String getdescfood() {
        return "火锅";
    }

    @Override
    public String getCost() {
        double cost = 3.0;
        return String.format("最后价格：%s块",cost);
    }

}
