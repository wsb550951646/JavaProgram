package com.DeepDesignPattern.CommandPattern.example;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2513:28
 */
@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "configs")
public class CommandConfigure {

    @XmlElement
    private List<Clazz> classes;

    public CommandConfigure() {
    }

    public CommandConfigure(List<Clazz> classes) {
        this.classes = classes;
    }

    public List<Clazz> getClasses() {
        return classes;
    }

    public void setClasses(List<Clazz> classes) {
        this.classes = classes;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Clazz{

        public Clazz() {
        }

        public Clazz(String packName, String className,List<String> args) {
            this.packName = packName;
            this.className = className;
            this.args = args;
        }

        @XmlElement
        private String packName;

        @XmlElement
        private String className;

        @XmlElementWrapper(name = "args")
        @XmlElement(name = "arg")
        private List<String> args;

        public String getPackName() {
            return packName;
        }

        public void setPackName(String packName) {
            this.packName = packName;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public List<String> getArgs() {
            return args;
        }

        public void setArgs(List<String> args) {
            this.args = args;
        }
    }




}
