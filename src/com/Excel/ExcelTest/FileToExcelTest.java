package com.Excel.ExcelTest;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/3013:35
 */
public class FileToExcelTest {



    @org.junit.Test
    public void test_1() throws FileNotFoundException, DocumentException {

        String cn = "D:\\JavaProgram\\src\\com\\Excel\\Properties\\web-warning.xml";
        String en  = "D:\\JavaProgram\\src\\com\\Excel\\Properties\\web-warning-en.xml";
        HashMap<String, HashMap<String, String>> xml = getWarningXml(cn,en);



    }

    @org.junit.Test
    public void test_xml() throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();

        // 通过read方法加载xml文件，获取document对象
        InputStream inputStream = new FileInputStream("D:\\JavaProgram\\src\\com\\Excel\\Properties\\resource.xml");
        Document document  = saxReader.read(inputStream);
        // 通过document对象获取根节点
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        //获取子节点
        List<Element> nodes = rootElement.elements();


        for(Element node: nodes){

            System.out.println("key:"+node.attributeValue("key")
                    +"---Value:"+node.getStringValue());
        }

    }

    public static HashMap<String, HashMap<String, String>> getWarningXml(String cnXml, String enXml) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        HashMap<String,HashMap<String,String>> result = new LinkedHashMap<>();

        // 通过read方法加载xml文件，获取document对象
        InputStream inputStream = new FileInputStream(cnXml);
        Document documentCN  = saxReader.read(inputStream);
        // 通过document对象获取根节点
        Element rootElement = documentCN.getRootElement();
        List<Element> nodesCN = rootElement.elements();

        InputStream inputStreamEn = new FileInputStream(enXml);
        Document documentEN = saxReader.read(inputStreamEn);
        Element rootElementEN = documentEN.getRootElement();
        List<Element> nodesEN = rootElementEN.elements();

        for(Element nodeEn: nodesEN){

            String key = nodeEn.attributeValue("id");

            for(Element nodeCN: nodesCN){

                if(nodeCN.attributeValue("id").equalsIgnoreCase(key)){

                    HashMap<String,String> CNEN = new HashMap<>();
                    //添加中英文值
                    CNEN.put(nodeCN.attributeValue("description"),nodeEn.attributeValue("description"));
                    result.put(key, CNEN);
                    System.out.println("key:"+key+"---cnValue:"+nodeCN.attributeValue("description")+"---enValue:"+nodeEn.attributeValue("description"));
                    //找到后退出
                    break;
                }

            }

        }

            return result;

    }


    public static HashMap<String,HashMap<String,String>> getXml(String cnXml,String enXml) throws FileNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        HashMap<String,HashMap<String,String>> result = new LinkedHashMap<>();

        // 通过read方法加载xml文件，获取document对象
        InputStream inputStream = new FileInputStream(cnXml);
        Document documentCN  = saxReader.read(inputStream);
        // 通过document对象获取根节点
        Element rootElement = documentCN.getRootElement();
        List<Element> nodesCN = rootElement.elements();

        InputStream inputStreamEn = new FileInputStream(enXml);
        Document documentEN = saxReader.read(inputStreamEn);
        Element rootElementEN = documentEN.getRootElement();
        List<Element> nodesEN = rootElementEN.elements();

        for(Element nodeEn: nodesEN){

            String key = nodeEn.attributeValue("key");

           for(Element nodeCN: nodesCN){

               if(nodeCN.attributeValue("key").equalsIgnoreCase(key)){

                   HashMap<String,String> CNEN = new HashMap<>();
                   //添加中英文值
                   CNEN.put(nodeCN.getStringValue(),nodeEn.getStringValue());
                   result.put(key, CNEN);
                   System.out.println("key:"+key+"---cnValue:"+nodeCN.getStringValue()+"---enValue:"+nodeEn.getStringValue());
                   //找到后退出
                   break;
               }
           }

        }

        return result;
    }


    public static HashMap<String,HashMap<String,String>> getProperties(String cnProperties,String enProperties){

        int i = 0;
        String cnValue = null;
        String enValue = null;
        String enbaseFile = enProperties;
        String cnbaseFile = cnProperties;
        HashMap<String,HashMap<String,String>> total = new LinkedHashMap <>();
        try {
            InputStream inputStream = new FileInputStream(enbaseFile);
            InputStream inputStreamCN = new FileInputStream(cnbaseFile);

            //自定义的properties
            OrderedProperties properties = new OrderedProperties();
            properties.load(inputStream);
            Set<Object> entries = properties.keySet();
            Iterator<Object> iterator = entries.iterator();

            OrderedProperties propertiesCn = new OrderedProperties();
            propertiesCn.load(inputStreamCN);

            while (iterator.hasNext()){

                HashMap<String,String> CN_EN = new LinkedHashMap <>();
                String key = (String)iterator.next();

                //中文中相同的key
                if(propertiesCn.containsKey(key)){

                    String CnValue = propertiesCn.getProperty(key);
                    String EnValue = properties.getProperty(key);

                    CN_EN.put(CnValue,EnValue);
                    total.put(key, CN_EN);

                    //System.out.println("key:"+key+"---Cnvalue:"+CnValue+"---Envalue:"+EnValue);
                    //i++;
                }


            }
            for(Map.Entry<String,HashMap<String,String>> entry:total.entrySet()){

                String rkey = entry.getKey();
                for(Map.Entry<String,String> entry1:entry.getValue().entrySet()){

                     cnValue = entry1.getKey();
                     enValue = entry1.getValue();

                }
                i++;
                System.out.println("key:"+rkey+"---cnValue:"+cnValue+"----enValue:"+enValue);

            }
            System.out.println(i);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return total;
    }


    public static void addExcelData(String[] titles, HashMap<String,HashMap<String,String>> result, WritableSheet sheet) throws WriteException {

        int i = 1;

        //5:单元格
        Label label=null;

        //6:给第一行设置列名
        for(int n=0;n<titles.length;n++){
            //x,y,第一行的列名
            label=new Label(n,0,titles[n]);
            //7：添加单元格
            sheet.addCell(label);
        }
        //8：模拟数据库导入数据

        for(Map.Entry<String,HashMap<String,String>> entry:result.entrySet()){
            //添加编号，第二行第一列   c:表示列   r:表示行   cont：添加的数据
            label=new Label(0,i,entry.getKey());
            sheet.addCell(label);

            for(Map.Entry<String,String> entryCNEN:entry.getValue().entrySet()){
                //添加中文
                label=new Label(1,i,entryCNEN.getKey());
                sheet.addCell(label);

                //添加英文
                label=new Label(2,i,entryCNEN.getValue());
                sheet.addCell(label);

            }

            i++;


        }

    }

    public static WritableWorkbook addExcelDatas(HashMap<String,String> filePathMap, WritableWorkbook workbook) throws WriteException, FileNotFoundException, DocumentException {


        int i = 1;
        for(Map.Entry<String,String> propertiesEntry:filePathMap.entrySet())
        {

            HashMap<String,HashMap<String,String>> result = new LinkedHashMap <>();

            String fileName = propertiesEntry.getKey().substring(propertiesEntry.getKey().lastIndexOf("\\")+1);

            if(fileName.endsWith(".properties")){

                result  = FileToExcelTest.getProperties(propertiesEntry.getKey(),propertiesEntry.getValue());
                String cnFileName = propertiesEntry.getKey();

                //sheet 的名字
                String sheetName = cnFileName.substring(cnFileName.lastIndexOf("\\")+1,cnFileName.indexOf("_"));


                //3:创建sheet,设置第二三四..个sheet，依次类推即可
                WritableSheet sheet=workbook.createSheet(sheetName, i);

                //4：设置titles
                String[] titles={"字符串宏定义","中文","英文"};

                //5.写入数据
                FileToExcelTest.addExcelData(titles, result, sheet);

                i++;
            } else if(fileName.endsWith(".xml") && fileName.contains("warning")){

                result  = FileToExcelTest.getWarningXml(propertiesEntry.getKey(),propertiesEntry.getValue());
                String sheetName = fileName.substring(0, fileName.lastIndexOf("."));

                WritableSheet sheet=workbook.createSheet(sheetName, i);
                String[] titles={"告警ID","中文","英文"};
                FileToExcelTest.addExcelData(titles, result, sheet);
                i++;

            }else if(fileName.endsWith(".xml")){

                result  = FileToExcelTest.getXml(propertiesEntry.getKey(),propertiesEntry.getValue());
                String sheetName = fileName.substring(0, fileName.lastIndexOf("."));

                WritableSheet sheet=workbook.createSheet(sheetName, i);
                String[] titles={"字符串宏定义","中文","英文"};
                FileToExcelTest.addExcelData(titles, result, sheet);
                i++;
            }

        }

        return workbook;

    }




    public static void main(String[] args) throws IOException, WriteException, DocumentException {

        HashMap<String,String> c = new HashMap<>();
        HashMap<String,String> propertiesHashMap = new HashMap<>();
        HashMap<String,String> xmlHashMap = new HashMap<>();
        //sheet 序号
        int i  = 0;

        //key zh  value en
        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\cloud-resources_zh_CN.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\cloud-resources_en_US.properties");

        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\resources_zh_CN.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\resources_en_US.properties");


        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\web-resource_zh.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\web-resource_en.properties");

        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\ui\\resource_zh.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\ui\\resource_en.properties");

        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\resource.xml",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\resource-en.xml");

        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\warning.xml",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\warning-en.xml");

        propertiesHashMap.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\web-warning.xml",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\web-warning-en.xml");


        //1:创建excel文件
        File file=new File("离线转码.xls");
        file.createNewFile();

        //2:创建工作簿
        WritableWorkbook workbook= Workbook.createWorkbook(file);

        workbook = FileToExcelTest.addExcelDatas(propertiesHashMap,workbook);

        //写入数据，一定记得写入数据
        workbook.write();
        //最后一步，关闭工作簿
        workbook.close();
    }

}
