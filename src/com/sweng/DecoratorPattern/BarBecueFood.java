package com.sweng.DecoratorPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/5/910:19
 */
public class BarBecueFood implements food  {

    @Override
    public String getdescfood() {

        return "烧烤";
    }

    @Override
    public String getCost() {

        double cost= 5.0;
        return String.format("最后价格：%s块", cost);
    }
}
