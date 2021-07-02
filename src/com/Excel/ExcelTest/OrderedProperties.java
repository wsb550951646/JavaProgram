package com.Excel.ExcelTest;

import java.io.File;
import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/3014:44
 */
public class OrderedProperties extends Properties {
    private static final long serialVersionUID = -4627607243846121965L;

    private File file;
    private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();

    public OrderedProperties() {
        // TODO Auto-generated constructor stub
    }

    public OrderedProperties(File file) {
        // TODO Auto-generated constructor stub
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Enumeration<Object> keys() {
        return Collections.enumeration(keys);
    }

    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    public Set<Object> keySet() {
        return keys;
    }

    public Set<String> stringPropertyNames() {
        Set<String> set = new LinkedHashSet<String>();
        for (Object key : this.keys) {
            set.add((String) key);
        }
        return set;
    }

}
