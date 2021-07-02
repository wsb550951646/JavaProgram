package com.sweng.proxy.StaticProxy;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1813:36
 */
public class Nike implements ClothFactory {

    public Nike() {
    }

    @Override
    public void produceCloth() {
        System.out.println("NIKE 开始生产");
    }
}
