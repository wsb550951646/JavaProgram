package com.XML.XMLConverToObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1314:33
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "info")
public class Time {

    public Time(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Time() {

    }

    @XmlJavaTypeAdapter(value = TimestampAdapter.class, type = Timestamp.class)
    private Timestamp createTime;

}
