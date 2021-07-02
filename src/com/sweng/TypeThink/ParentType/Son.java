package com.sweng.TypeThink.ParentType;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1419:37
 */
public class Son extends Parent {

    private Integer age;
    private String name;

    public Son(Integer age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Son{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
