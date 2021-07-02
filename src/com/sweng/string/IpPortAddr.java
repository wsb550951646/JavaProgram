package com.sweng.string;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/4/916:57
 */
public class IpPortAddr {

    public String ip;
    public String port;

    public IpPortAddr(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public IpPortAddr() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
