package com.IO.File;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1310:12
 */
public class TreeInfo implements Iterable<File> {

    //创建一个文件，一个文件夹的存储
    private List<File> files = new ArrayList<>();
    private List<File> dirs = new ArrayList<>();

    @Override
    public Iterator<File> iterator() {
        return null;
    }

    public void addAll(TreeInfo treeInfo){
        files.addAll(treeInfo.files);
        dirs.addAll(treeInfo.dirs);
    }

    //递归目录，是dir目录则继续调用recurseDirs
    static TreeInfo recurseDirs(File startDir,String reg){

        TreeInfo result = new TreeInfo();
        for(File item:startDir.listFiles()){

            if(item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item, reg));
            }else
            {
                if(item.getName().matches(reg))
                result.files.add(item);
            }

        }
        return result;
    }

    //接口
    public static TreeInfo walk(String start,String regex){

        return recurseDirs(new File(start), regex);

    }

    public static TreeInfo walk(File file,String regex){

        return recurseDirs(file, regex);

    }

    public static TreeInfo walk(File file){
        return recurseDirs(file,".*");
    }

    public static TreeInfo walk(String path){
        return recurseDirs(new File(path), ".*");
    }

    public static void main(String[] args) {

        File file = new File(".");
        TreeInfo walk = walk(file);

        for(File f:walk.files){
            System.out.println("file:"+f.getName());
        }
        for(File f2:walk.dirs){
            System.out.println("dir:"+f2.getName());
        }


    }





}
