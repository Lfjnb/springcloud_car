package com.jk.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

public class AppointmentBean implements Serializable {

    private static final long serialVersionUID = 4897923927513412377L;
      private  Integer  id;//id
      private  String   phone;//用户手机号
      private  Integer  area;//预约看车地区
      private  String   lookcartime;//预约看车时间
      private  Integer  carid;//车表
      private  Integer  status;//0预约1交易完成


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getLookcartime() {
        return lookcartime;
    }

    public void setLookcartime(String lookcartime) {
        this.lookcartime = lookcartime;
    }
}
