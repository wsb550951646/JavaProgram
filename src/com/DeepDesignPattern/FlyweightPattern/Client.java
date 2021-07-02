package com.DeepDesignPattern.FlyweightPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2315:34
 */
public class Client {

    public static final String WEIBO_CLASS = "com.DeepDesignPattern.FlyweightPattern.Weibo";
    public static final String WEIXIN_CLASS = "com.DeepDesignPattern.FlyweightPattern.WeChat";

    public static void main(String[] args) throws Exception {

        WebSite webSite = WebSiteFactory.getWebSite(WEIBO_CLASS);

        webSite.display(new User("Jerry"));

        WebSite webSite2 = WebSiteFactory.getWebSite(WEIBO_CLASS);

        webSite2.display(new User("Tom"));

        WebSite webSite3 = WebSiteFactory.getWebSite(WEIBO_CLASS);

        webSite3.display(new User("Queue"));

        WebSite webSite4 = WebSiteFactory.getWebSite(WEIXIN_CLASS);

        webSite4.display(new User("King"));

        WebSite webSite1 = WebSiteFactory.getWebSite(WEIXIN_CLASS);

        webSite1.display(new User("Jerry"));

        System.out.println("当前网址有："+WebSiteFactory.getSize());


    }

}
