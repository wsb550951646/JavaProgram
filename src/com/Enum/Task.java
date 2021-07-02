package com.Enum;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1918:32
 */
public enum Task {

    //这个就是默认的name属性，后面构造函数的就是自定义的属性。
    UPLOADING(10),
    DOWNLOADED(11),
    TRANSCODED(12);

    private byte id;

    public String getKey() {
        return this.name();
    }

    private Task(int id) {
        this.id = (byte)id;
    }

    public byte getId() {
        return this.id;
    }
}
