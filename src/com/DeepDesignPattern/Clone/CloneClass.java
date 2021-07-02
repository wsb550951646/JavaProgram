package com.DeepDesignPattern.Clone;

import java.io.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/189:58
 */
public class CloneClass implements Cloneable,Serializable {

    private String name;
    private Person person;

    public CloneClass(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public CloneClass() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CloneClass Myclone(){

        CloneClass cloneClass = new CloneClass();
        cloneClass.setName(this.getName());

        //直接赋值person 存在引用
        Person person = new Person();
        person.setAge(this.getPerson().getAge());
        person.setPersonName(this.getPerson().getPersonName());
        cloneClass.setPerson(person);
        return cloneClass;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {

        CloneClass cloneClass = null;

        cloneClass = (CloneClass)super.clone();

        //person 单独再克隆一次

        Person clone = (Person)person.clone();

        cloneClass.setPerson(clone);

        return cloneClass;

    }

    public CloneClass deepClone(){

        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            CloneClass cloneClass = (CloneClass) ois.readObject();
            return cloneClass;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

}
