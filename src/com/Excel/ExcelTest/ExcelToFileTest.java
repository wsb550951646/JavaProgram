package com.Excel.ExcelTest;

import com.Container.Hash.LinkedHash;
import jxl.Sheet;
import jxl.Workbook;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1313:42
 */
public class ExcelToFileTest {

    @Test
    public void test_2() throws IOException, DocumentException {


        String path = "D:\\JavaProgram\\src\\com\\Excel\\Properties\\warning.xml";
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = new FileInputStream(path);
        Document document  = saxReader.read(inputStream);
        // 通过document对象获取根节点
        Element rootElement = document.getRootElement();
        List<Element> nodes = rootElement.elements();


        for(Element node:nodes){

            if(node.attributeValue("id").equals("0x02000001")){

                Attribute description = node.attribute("description");
                description.setValue("任务自动重启Test");
                System.out.println("ok");

                break;
            }

        }




    }


    @Test
    public void test(){


    }

    public static void main(String[] args) throws Exception {


        HashMap<String, HashMap<String, String>> proMap = new HashMap<>();
        HashMap<String, String> proPath1 = new HashMap<>();
        HashMap<String, String> proPath2 = new HashMap<>();
        HashMap<String, String> proPath3 = new HashMap<>();
        HashMap<String, String> proPath4 = new HashMap<>();
        proPath1.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\cloud-resources_zh_CN.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\cloud-resources_en_US.properties");

        proPath2.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\resources_zh_CN.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\resources_en_US.properties");

        proPath3.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\web-resource_zh.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\web-resource_en.properties");

        proPath4.put("D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\ui\\resource_zh.properties",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\coordinatorapp\\ui\\resource_en.properties");

        proMap.put("cloud-resources",proPath1);
        proMap.put("resources",proPath2);
        proMap.put("web-resource",proPath3);
        proMap.put("resource_task_ui",proPath4);

        //------

        HashMap<String, HashMap<String, String>> XMLMap = new HashMap<>();
        HashMap<String, String> XMLPath1 = new HashMap<>();

        XMLPath1.put( "D:\\JavaProgram\\src\\com\\Excel\\Properties\\resource.xml",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\resource-en.xml");
        XMLMap.put("resource",XMLPath1);

        //-------

        HashMap<String, HashMap<String, String>> warningXMLMap = new HashMap<>();
        HashMap<String, String> warningXMLPath1 = new HashMap<>();
        HashMap<String, String> warningXMLPath2 = new HashMap<>();

        warningXMLPath1.put( "D:\\JavaProgram\\src\\com\\Excel\\Properties\\warning.xml",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\warning-en.xml");
        warningXMLPath2.put( "D:\\JavaProgram\\src\\com\\Excel\\Properties\\web-warning.xml",
                "D:\\JavaProgram\\src\\com\\Excel\\Properties\\web-warning-en.xml");
        warningXMLMap.put("warning",warningXMLPath1);
        warningXMLMap.put("web-warning",warningXMLPath2);


        String ExcelPath = "C:\\Users\\sweng.ARCVIDEO\\Desktop\\离线字符表.xls";
        File Excelfile = new File(ExcelPath);

        ExcelToFileTest excel = new ExcelToFileTest();

        for(Map.Entry<String,HashMap<String,String>> entry:proMap.entrySet()){

            LinkedHashMap<String, HashMap<String, String>> result = new LinkedHashMap<>();
            result = excel.readExcel(Excelfile,entry.getKey());

            for(Map.Entry<String,String> e:entry.getValue().entrySet()){
                //中文
                excel.writeProperties(e.getKey(), result);
                //英文
                excel.writeProperties(e.getValue(), result);
            }


        }

        for(Map.Entry<String,HashMap<String,String>> entry:XMLMap.entrySet()){

            LinkedHashMap<String, HashMap<String, String>> result = new LinkedHashMap<>();
            result = excel.readExcel(Excelfile,entry.getKey());

            for(Map.Entry<String,String> e:entry.getValue().entrySet()){
                //中文
                excel.writeXML(e.getKey(), result);
                //英文
                excel.writeXML(e.getValue(), result);
            }


        }

        for(Map.Entry<String,HashMap<String,String>> entry:warningXMLMap.entrySet()){

            LinkedHashMap<String, HashMap<String, String>> result = new LinkedHashMap<>();
            result = excel.readExcel(Excelfile,entry.getKey());

            for(Map.Entry<String,String> e:entry.getValue().entrySet()){
                //中文
                excel.writeWarningXML(e.getKey(), result);
                //英文
                excel.writeWarningXML(e.getValue(), result);
            }


        }





    }

    public void writeWarningXML(String path, LinkedHashMap<String, HashMap<String,String>> data)throws Exception{

        SAXReader saxReader = new SAXReader();
        InputStream inputStream = new FileInputStream(path);
        Document document  = saxReader.read(inputStream);
        // 通过document对象获取根节点
        Element rootElement = document.getRootElement();
        List<Element> nodes = rootElement.elements();
        Attribute description =null;

        if(path.contains("-en")){
            for(Element node:nodes){

                String key = node.attributeValue("id");

                for(Map.Entry<String,HashMap<String,String>> Entrys:data.entrySet()){

                    //相同的key
                    if(key.equals(Entrys.getKey()))
                    {

                        for(Map.Entry<String,String> entry:Entrys.getValue().entrySet())
                        {
                            //在description  属性中写入英文
                            description = node.attribute("description");
                            description.setValue(entry.getValue());

                        }
                        break;

                    }
                }
            }

        }
        else {

            for(Element node:nodes){

                String key = node.attributeValue("id");

                for(Map.Entry<String,HashMap<String,String>> Entrys:data.entrySet()){

                    //相同的key
                    if(key.equals(Entrys.getKey()))
                    {

                        for(Map.Entry<String,String> entry:Entrys.getValue().entrySet())
                        {
                            //在description  属性中写入中文
                            description = node.attribute("description");
                            description.setValue(entry.getKey());

                        }
                        break;

                    }
                }
            }
        }

        FileOutputStream fout = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint(); // 获取输出的指定格式
        format.setEncoding("UTF-8");// 设置编码 ，确保解析的xml为UTF-8格式

        XMLWriter xmlWriter = new XMLWriter(fout, format);
        xmlWriter.write(document);
        xmlWriter.flush();
        fout.flush();
        xmlWriter.close();
        fout.close();
        inputStream.close();




    }

    public void writeXML(String path,LinkedHashMap<String, HashMap<String,String>> data) throws Exception{


        SAXReader saxReader = new SAXReader();
        InputStream inputStream = new FileInputStream(path);
        Document document  = saxReader.read(inputStream);
        // 通过document对象获取根节点
        Element rootElement = document.getRootElement();
        List<Element> nodes = rootElement.elements();

        if(path.contains("-en")){

            for(Element node:nodes){

                String key = node.attributeValue("key");

                for(Map.Entry<String,HashMap<String,String>> Entrys:data.entrySet()){

                    //相同的key
                    if(key.equals(Entrys.getKey()))
                    {

                        for(Map.Entry<String,String> entry:Entrys.getValue().entrySet())
                            //英文
                            node.setText(entry.getValue());


                        break;
                    }
                }
            }
        }else {

            for(Element node:nodes){

                String key = node.attributeValue("key");

                for(Map.Entry<String,HashMap<String,String>> Entrys:data.entrySet()){

                    //相同的key
                    if(key.equals(Entrys.getKey()))
                    {

                        for(Map.Entry<String,String> entry:Entrys.getValue().entrySet())
                            //中文
                            node.setText(entry.getKey());

                        break;
                    }
                }
            }
        }

        //重写回
        FileOutputStream fout = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint(); // 获取输出的指定格式
        format.setEncoding("UTF-8");// 设置编码 ，确保解析的xml为UTF-8格式

        XMLWriter xmlWriter = new XMLWriter(fout, format);
        xmlWriter.write(document);
        xmlWriter.flush();
        fout.flush();
        xmlWriter.close();
        fout.close();
        inputStream.close();

    }



    public void writeProperties(String path,LinkedHashMap<String, HashMap<String,String>> data) throws IOException {

        OrderedProperties properties = new OrderedProperties();
        FileOutputStream fout = new FileOutputStream(path);

           if(path.contains("_zh")){
               for(Map.Entry<String,HashMap<String,String>> keyEntr:data.entrySet()){

                   String key = keyEntr.getKey();
                   String cn = null;

                   for(Map.Entry<String,String> entry:keyEntr.getValue().entrySet()){

                       cn = entry.getKey();

                   }
                   properties.setProperty(key,cn);

               }

           }else {
               for(Map.Entry<String,HashMap<String,String>> keyEntr:data.entrySet()){

                   String key = keyEntr.getKey();
                   String en = null;

                   for(Map.Entry<String,String> entry:keyEntr.getValue().entrySet()){

                       en = entry.getValue();

                   }
                   properties.setProperty(key,en);

               }

           }

        properties.store(fout, null);
        fout.flush();
        fout.close();

    }

    public LinkedHashMap<String, HashMap<String,String>> readExcel(File file,String sheetName) throws Exception {

        String key = null;
        String en = null;
        String cn = null;
        FileInputStream fin = new FileInputStream(file);

        Workbook wb = Workbook.getWorkbook(fin);

        LinkedHashMap<String, HashMap<String, String>> result = new LinkedHashMap<String, HashMap<String, String>>();


            //通过Name获取Sheet
            Sheet sheet = wb.getSheet(sheetName);

            if(sheet==null)
                return null;

            //一个页签的行
            for (int i = 1; i < sheet.getRows(); i++) {

                //一个页签的列
                for (int j = 0; j < sheet.getColumns(); j++) {

                    //获取第 i 行 第 j 列的数据
                    String cellinfo = sheet.getCell(j,i).getContents();

                    if (cellinfo.isEmpty()){
                        continue;
                    }
                    //不同列，获取不同的数据
                    switch (j){
                        case 0:
                            key = cellinfo;
                            break;
                        case 1:
                             cn = cellinfo;
                            break;
                        case 2:
                             en = cellinfo;
                            break;
                        default:
                            break;
                    }
                }
                HashMap<String, String> CNEN = new HashMap<String,String>();
                CNEN.put(cn, en);
                result.put(key, CNEN);

            }
        return result;
    }

}
