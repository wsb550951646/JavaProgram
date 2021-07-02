package com.IO.File;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/139:17
 */
public class DirFilter  {

    public static FilenameFilter filter(final String reg){

        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(reg);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };



    }

    public static void main(String[] args) {

        File path = new File(".");
        String[] list;
        if(args.length==0)
            list = path.list();
        else
            list = path.list(filter(args[0]));

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }

    }

    @Test
    public void test(){

        File path = new File(".");
        String[] list2;
        final String reg = "k";
        list2 = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(reg);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });

        for(String s:list2){
            System.out.println(s);
        }




    }



}
