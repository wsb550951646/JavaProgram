package com.DeepDesignPattern.Clone;

import java.io.Serializable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/189:58
 */
public class Person implements Cloneable, Serializable {

    private Integer id;
    private String personName;
    private String age;

    public Person(String personName, String age) {
        this.personName = personName;
        this.age = age;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Person person = (Person) o;

        if (id.intValue() == person.getId().intValue()) {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return result;
    }
}
