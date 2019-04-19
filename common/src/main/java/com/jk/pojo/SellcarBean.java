package com.jk.pojo;

import java.io.Serializable;

public class SellcarBean implements Serializable {

    private static final long serialVersionUID = -3486802132151061232L;
    private  Integer  id;//id

     private  String  phone;//手机号

     private  String  cartype;//车类型

     private  String  carseries;//车系

     private  String  licensetime;//上牌时间

     private  Integer mileage;//里程数

     private  Integer licensearea;//地区

     private  String  testcartime;//验车时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getCarseries() {
        return carseries;
    }

    public void setCarseries(String carseries) {
        this.carseries = carseries;
    }

    public String getLicensetime() {
        return licensetime;
    }

    public void setLicensetime(String licensetime) {
        this.licensetime = licensetime;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getLicensearea() {
        return licensearea;
    }

    public void setLicensearea(Integer licensearea) {
        this.licensearea = licensearea;
    }

    public String getTestcartime() {
        return testcartime;
    }

    public void setTestcartime(String testcartime) {
        this.testcartime = testcartime;
    }
}
