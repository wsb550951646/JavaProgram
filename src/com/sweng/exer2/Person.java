package com.sweng.exer2;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/179:38
 */
public class Person<T extends Info>  {

    private T TInfo;

    public Person() {
    }

    public Person(T TInfo) {
        this.TInfo = TInfo;
    }

    public T getTInfo() {
        return TInfo;
    }

    public void setTInfo(T TInfo) {
        this.TInfo = TInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "TInfo=" + TInfo +
                '}';
    }

}
