package com.DeepDesignPattern.FlyweightPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2315:30
 */
public class WeChat implements WebSite {
    @Override
    public void display(User user) {
        System.out.println("正在使用微信网址 使用者为"+user.getName());
    }
}
