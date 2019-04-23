package com.jk.pojo;

import java.io.Serializable;

/**
 * 内部配置
 */
public class InternalBean implements Serializable {

    private static final long serialVersionUID = 929076065370573075L;
    private Integer id;

    private Integer allSteering;//多功能方向盘 1：标配  2：无

    private Integer cruiseControl;//定速巡航 1：标配  2：无

    private Integer cold;//空调 1：标配  2：无

    private Integer zidongCold;//自动空调 1：标配  2：无

    private Integer gPS;//GPS导航 1：标配  2：无

    private Integer radar;//倒车雷达 1：标配  2：无

    private Integer daocheImage;//倒车影像系统 1：标配  2：无

    private Integer leatherSeats;//真皮座椅 1：标配  2：无

    private Integer seatHot;//前后排座椅加热 1：标配/标配  2：标配/无 3：无/无

    private Integer carId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAllSteering() {
        return allSteering;
    }

    public void setAllSteering(Integer allSteering) {
        this.allSteering = allSteering;
    }

    public Integer getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(Integer cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public Integer getCold() {
        return cold;
    }

    public void setCold(Integer cold) {
        this.cold = cold;
    }

    public Integer getZidongCold() {
        return zidongCold;
    }

    public void setZidongCold(Integer zidongCold) {
        this.zidongCold = zidongCold;
    }

    public Integer getgPS() {
        return gPS;
    }

    public void setgPS(Integer gPS) {
        this.gPS = gPS;
    }

    public Integer getRadar() {
        return radar;
    }

    public void setRadar(Integer radar) {
        this.radar = radar;
    }

    public Integer getDaocheImage() {
        return daocheImage;
    }

    public void setDaocheImage(Integer daocheImage) {
        this.daocheImage = daocheImage;
    }

    public Integer getLeatherSeats() {
        return leatherSeats;
    }

    public void setLeatherSeats(Integer leatherSeats) {
        this.leatherSeats = leatherSeats;
    }

    public Integer getSeatHot() {
        return seatHot;
    }

    public void setSeatHot(Integer seatHot) {
        this.seatHot = seatHot;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
