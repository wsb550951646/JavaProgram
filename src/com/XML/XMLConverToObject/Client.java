package com.XML.XMLConverToObject;

import com.DeepDesignPattern.FlyweightPattern.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2510:30
 */
public class Client {

    public static void main(String[] args) {


        XmlUtil xmlUtil = new XmlUtil();

        UserConfigure.User user = new UserConfigure.User("Tom", 12, "man", "HZ", new UserConfigure.Company("DH", "HZ"));

        UserConfigure.User user1 = new UserConfigure.User("Jerry", 22, "man", "BJ", new UserConfigure.Company("TenXun", "BJ"));

        UserConfigure userConfigure = new UserConfigure();

        userConfigure.setConfig(Arrays.asList(user1,user));

        String s = xmlUtil.convertToStringXml(userConfigure);
        System.out.println(s);

        //转化为类的时候需要使用 空的构造函数！！！
        UserConfigure userConfigure1 = xmlUtil.StringconverToObject(UserConfigure.class, s);

        System.out.println(userConfigure1);

        xmlUtil.ConverToFileXml(userConfigure, "1.txt");

        UserConfigure userConfigure2 = xmlUtil.FileConverToObject(UserConfigure.class, "1.txt");

        System.out.println(userConfigure2);

    }

}
