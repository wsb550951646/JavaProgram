package com.IO.File;

import com.sun.deploy.util.StringUtils;
import jxl.biff.StringHelper;


import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1715:38
 */
public class FileAPITest {

    public static void main(String[] args) {

        String nud = null;
        File file1 = new File(nud,"E:\\TestFile\\xx");
        System.out.println(file1.getAbsolutePath());

        System.out.println("parent:"+file1.getParent());

        File file = new File("E:\\TestFile");

        /*
            获取文件夹下的 文件    (只是当前目录)

            file.list()的两种过滤方法

            1.      使用匿名类的lambda表达式
            file.list((dir, name) -> {
                file2 = new File(dir,name);
                //对文件dir 和 name名称进行过滤。使用Lambda表达式
            });

            2.     去实现类FilenameFilter()
            file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
               if(name.toUpperCase().endsWith(".txt"))
                   return true;
               else
                   return false;
                }
            });

        */
        String[] list1 = file.list((dir, name) -> {
            System.out.println("dir:" + dir);
            System.out.println("name:" + name);
            File file2 = new File(dir, name);
            return file2.isDirectory();
        });
        for (String x : list1)
        System.out.println(x);

        //file.list 获取当前目录下的所有文件String名称
        String[] list = file.list();
        for(String s:list) {
            System.out.println(s);
        }

        //file.lists 获取当前目录下所有文件的file
        System.out.println("-------------");
        File[] files = file.listFiles();
        for(File f:files) {
            System.out.println(f.getName());
            System.out.println("s:"+f.getAbsolutePath());
        }
        
        //file 带过滤的
        String[] list2 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
               if(name.toUpperCase().endsWith(".txt"))
                   return true;
               else
                   return false;
            }
        });
        System.out.println("list2--");
        for (String x : list2){
            System.out.println(x);
        }


        System.out.println("---2----");
        ArrayList<String> listFileName = new ArrayList<>();
        getAllFileName("E:\\TestFile",listFileName);
        for (String temp : listFileName)
        System.out.println(temp);


    }

    public static void getAllFileName(String path, List<String> listFileName){


        if(path.isEmpty() || path == null)
            return ;

        if(!path.endsWith(File.separator))
            path +=File.separator;

        File file = new File(path);
        String[] fileNames = file.list();
        File[] files = file.listFiles();

        if(fileNames.length == 0 || files.length == 0)
            return;

        for (int i = 0; i < files.length; i++) {

            if(files[i].isFile()){
                String completeName = path+files[i].getName();
                listFileName.add(completeName);
            }
            else if(files[i].isDirectory()){
                String completeName = path+files[i].getName();
                listFileName.add(completeName);
                getAllFileName(files[i].getAbsolutePath(),listFileName);

            }

        }





    }




}
