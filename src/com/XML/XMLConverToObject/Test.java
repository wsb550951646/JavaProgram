package com.XML.XMLConverToObject;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1217:42
 */

public class Test {

    final String REPRESENTATIONID = "\\$RepresentationID\\$";

    final String NUMBER = "\\$Number\\$";

    @org.junit.Test
    public void test1(){
        File file = new File("C:\\Users\\sweng.ARCVIDEO\\Desktop\\test\\aishang-052330_1243067 (2).mpd");
        System.out.println(file.getParent());       //不带  /斜杠的
        System.out.println(file.getName());         //啥都不带

    }

    @org.junit.Test
    public void testXMlFileToObject(){

        XmlUtil2 xmlUtil2 = new XmlUtil2();
        MPD object = (MPD) XmlUtil2.convertXmlFileToObject(MPD.class, "C:\\Users\\sweng.ARCVIDEO\\Desktop\\test\\aishang-052330_1243067 (2).mpd");
        List<File> files = new ArrayList<>();


        List<MPD.Period.Adaptation> adaptationList = object.getPeriod().getAdaptations();
        File filetop = new File("C:\\Users\\sweng.ARCVIDEO\\Desktop\\test\\aishang-052330_1243067-SDR.mpd");
        for(MPD.Period.Adaptation adaptation : adaptationList){
            //初始化文件模板
            String initialization = adaptation.getSegmentTemplate().getInitialization();
            //详细媒体模板
            String media = adaptation.getSegmentTemplate().getMedia();
            List<MPD.Period.Adaptation.Representation> representationList= adaptation.getRepresentation();

            for(MPD.Period.Adaptation.Representation representation : representationList){
                String representationId = representation.getId();
                String fileReg = media.replaceAll(REPRESENTATIONID,representationId).replaceAll(NUMBER, "\\\\d+");
                for(File each : filterFile(filetop, fileReg)){
                    files.add(each);
                }
                String initializationReg = initialization.replaceAll(REPRESENTATIONID, representationId);
                for(File each : filterFile(filetop,initializationReg)){
                    files.add(each);
                }
            }
        }
        for (File each : files){
            System.out.println(each.getName());
        }
    }

    public File[] filterFile(File file, String fileReg){

        File parentFile = file.getParentFile();

        final Pattern regex = Pattern.compile(fileReg, Pattern.CASE_INSENSITIVE);
        File[] files = parentFile.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (regex.matcher(pathname.getName()).matches())
                    return true;
                return false;
            }
        });

      return files;

    }

    @org.junit.Test
    public void TestTime(){

        Time time = new Time(new Timestamp(new Date().getTime()));
        String s = XmlUtil2.convertToXml(time);
        System.out.println(s);

    }

}
