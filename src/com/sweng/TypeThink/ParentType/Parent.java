package com.sweng.TypeThink.ParentType;

import java.io.Serializable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1419:37
 */
public class Parent implements Cloneable  {
    private Integer id;

    public Parent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                '}';
    }
}
