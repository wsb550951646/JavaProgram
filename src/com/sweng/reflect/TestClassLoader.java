package com.sweng.reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1715:15
 */
public class TestClassLoader {

    @Test
    public void test() throws IOException {

        //使用Properties和ClassLoader加载文件
        Properties properties = new Properties();

        //方式一：使用ClassLoader获取 默认的路径是Src下的路径
        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");

       //properties.load(is);

        //方式二：使用FileInputStream获取 默认的路径是Modules的路径
        //FileInputStream fileInputStream = new FileInputStream("jdbc1.properties");
        FileInputStream fileInputStream = new FileInputStream("src\\jdbc.properties");
       properties.load(fileInputStream);


        String name = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user="+name+",password="+password);

    }
}
