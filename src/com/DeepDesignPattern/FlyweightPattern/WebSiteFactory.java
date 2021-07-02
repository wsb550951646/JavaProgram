package com.DeepDesignPattern.FlyweightPattern;

import java.util.HashMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2315:23
 */
public class WebSiteFactory {

    private static HashMap<String,WebSite> websiteCache = new HashMap<>();

    private WebSiteFactory(){

    }

    private static WebSite getClassForName(String type) throws Exception {

        Class<?> clazz = null;
        clazz = clazz.forName(type);
        Object o;
        o = clazz.newInstance();

        if(o instanceof WebSite)
        return (WebSite)o;

        return null;
    }

    public static WebSite getWebSite(String type) throws Exception {

        WebSite result = null;

        if(type == null || type.isEmpty())
            return null;

        if(websiteCache.containsKey(type)){
            result = websiteCache.get(type);
        }else{
            WebSite webSite = getClassForName(type);
            result = webSite;
            websiteCache.put(type,webSite);
        }

        return result;
    }

    public static int getSize(){
        return websiteCache.size();
    }





}
