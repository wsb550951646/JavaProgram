package com.sweng.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/4/916:55
 */
public class testURL {


    public static String getIpFromUrl(String url) {
        // 1.判断是否为空
        if (url == null || url.trim().equals("")) {
            return "";
        }


        String host = "";
        Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
        Matcher matcher = p.matcher(url);
        if (matcher.find()) {
            host = matcher.group();
        }
        return host;
    }

    /**
     * 从url中分析出hostIP:PORT<br/>
     * @param url
     * @author wull	 */
    public static IpPortAddr getIpPortFromUrl(String url) {
        // 1.判断是否为空
        if (url == null || url.trim().equals("")) {
            return null;
        }

        String host = "";
        Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+(:\\d{0,5})?");
        Matcher matcher = p.matcher(url);
        if (matcher.find()) {
            host = matcher.group() ;
        }

        // 如果
        if(host.contains(":") == false){
            return new IpPortAddr(host, "80" );
        }

        String[] ipPortArr = host.split(":");
        return new IpPortAddr(ipPortArr[0] , ipPortArr[1] );
    }

    public static void main(String [] args){
        String url = "10.55.32.45/flv?app=huiju&stream=hjanhui_1_900";
        String url2 = "10.33.32.81/q.flv";
        System.out.println(testURL.getIpFromUrl(url) );
        IpPortAddr addr= testURL.getIpPortFromUrl(url) ;
        System.out.println(addr.getIp() +"=========>" +addr.getPort() );
    }

}
