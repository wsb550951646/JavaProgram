package com.DeepDesignPattern.DecoratePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2017:31
 */
public class Mike extends Decorate {

    public Mike(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2);

    }


}
