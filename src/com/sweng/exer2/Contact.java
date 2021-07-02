package com.sweng.exer2;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/179:37
 */
public class Contact implements Info {

    private int TelNumber;
    private String location;
    private String AddressNumber;

    public Contact(int telNumber, String location, String addressNumber) {
        TelNumber = telNumber;
        this.location = location;
        AddressNumber = addressNumber;
    }

    public Contact() {
    }

    public int getTelNumber() {
        return TelNumber;
    }

    public void setTelNumber(int telNumber) {
        TelNumber = telNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        AddressNumber = addressNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "TelNumber=" + TelNumber +
                ", location='" + location + '\'' +
                ", AddressNumber='" + AddressNumber + '\'' +
                '}';
    }
}
