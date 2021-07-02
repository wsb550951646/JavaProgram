package com.sweng.DecoratorPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/5/910:32
 */
public class SaltDecorator extends Decorator {

    public SaltDecorator(food food) {
        super(food);
    }

    @Override
    public String getdescfood() {
        return "加盐"+food.getdescfood();
    }

    @Override
    public String getCost() {
        Double salt = 2.0;
        System.out.println(String.format("加盐多收%s块", salt));
        String result = food.getCost() + " + " + salt + "块";
        return result;

    }
}
