package com.XML.XMLConverToObject;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/259:31
 */
@XmlAccessorType(XmlAccessType.FIELD)

//XML文件识别根据
@XmlRootElement(name="configs")

//控制JAXB 绑定类中属性和字段排序

public class UserConfigure {

    @XmlElement
    private List<User> config;

    public UserConfigure() {
    }

    public List<User> getConfig() {
        return config;
    }

    public void setConfig(List<User> config) {
        this.config = config;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class User {

        public User() {
        }

        public User(String name, Integer age, String sex, String address, Company company) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.company = company;
        }

        @XmlElement
        private String name;
        @XmlElement
        private Integer age;
        @XmlElement
        private String sex;
        @XmlElement
        private String address;

        @XmlElement
        private Company company;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    ", address='" + address + '\'' +
                    ", company=" + company +
                    '}';
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Company {

        public Company() {
        }

        public Company(String name, String address) {
            this.name = name;
            this.address = address;
        }

        @XmlElement
        private String name;
        @XmlElement
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserConfigure{" +
                "config=" + config +
                '}';
    }
}
