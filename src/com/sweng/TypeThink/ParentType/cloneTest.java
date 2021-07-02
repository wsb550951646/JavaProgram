package com.sweng.TypeThink.ParentType;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1420:16
 */
public class cloneTest implements Cloneable {

    private Integer id;

    public cloneTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
