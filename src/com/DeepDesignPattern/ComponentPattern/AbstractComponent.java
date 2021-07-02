package com.DeepDesignPattern.ComponentPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2311:01
 */
public abstract class AbstractComponent {

    private String name;
    private String des;

    public AbstractComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void add(AbstractComponent abstractComponent){
        throw new UnsupportedOperationException();
    }

    public void removeAll(){
        throw new UnsupportedOperationException();
    }

    public void remove(String name){
        throw new UnsupportedOperationException();
    }

    public abstract void display();


}
