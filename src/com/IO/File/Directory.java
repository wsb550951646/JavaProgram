package com.IO.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1310:04
 */
public class Directory {

    //调用listFiles并且使用匿名类创建FilenameFilter过滤文件 返回File[]
    public static File[] local(File file,final String reg){

        return file.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(reg);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });

    }

    //重载
    public static File[] local(String path,final String reg){
        return local(new File(path), reg);
    }


}
