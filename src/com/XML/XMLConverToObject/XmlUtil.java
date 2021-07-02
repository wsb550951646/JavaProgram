package com.XML.XMLConverToObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2510:24
 */
public class XmlUtil {

    //String XML 转化为 对象类
    public <T> T StringconverToObject(Class<T> clazz,String xml){

        if(xml == null || xml.isEmpty())
            return null;
        T t = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            t= (T)unmarshaller.unmarshal(new StringReader(xml));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return t;
    }


    //对象类 转化为 StringXml
    public <T> String  convertToStringXml(T t){

        StringWriter sw = new StringWriter();

        if(t == null)
            return null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(t, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return sw.toString();
    }

    //文件路径Xml 转化为 对象类
    public <T> T FileConverToObject(Class<T> clazz,String xmlPath){

        T t = null;

        if(xmlPath == null || xmlPath.isEmpty())
            return null;

        if(clazz == null)
            return null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            t = (T)unmarshaller.unmarshal(new FileReader(xmlPath));


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return t;
    }

    //对象类 转化为 文件的XML
    public <T> void ConverToFileXml(T t,String pathXml){

        if(pathXml == null || pathXml.isEmpty())
            return;

        if( t == null)
            return;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(t, new FileWriter(pathXml));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
