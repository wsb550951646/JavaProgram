package com.XML.XMLConverToObject;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/5/1314:36
 */
public class TimestampAdapter extends XmlAdapter<Date, Timestamp> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    @Override
    public Timestamp unmarshal(Date v) throws Exception {
        return new Timestamp(v.getTime());
    }

    @Override
    public Date marshal(Timestamp v) throws Exception {     //marshal 集合。 输出为xml
        return new Date(v.getTime());
    }
}
