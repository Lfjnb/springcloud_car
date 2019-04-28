package com.jk.pojo;

public class AppotionBean {

    private Integer id;//预约编号id
    private String phone;//买家手机号
    private Integer carid;//汽车ID
    private Integer status;
    private String lookcartime;//预约时间
    private String ownerId; //卖家手机号
    private String brandName;//车辆品牌
    private String seriesName;//车系

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

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLookcartime() {
        return lookcartime;
    }

    public void setLookcartime(String lookcartime) {
        this.lookcartime = lookcartime;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}