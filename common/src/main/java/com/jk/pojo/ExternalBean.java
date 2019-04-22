package com.jk.pojo;

import java.io.Serializable;

/**
 *外部配置
 */
public class ExternalBean implements Serializable {

    private static final long serialVersionUID = -3882022696812083506L;
    private Integer id;

    private Integer powerSunroof;//电动天窗 1：标配  2：无

    private Integer allSunroof;//全景天窗 1：标配  2：无

    private Integer powerDoor;//电动吸合门 1：标配  2：无

    private Integer ganyingBox;//感应后备箱 1：标配  2：无

    private Integer ganyiBrush;//感应雨刷 1：标配  2：无

    private Integer houBrush;//后雨刷 1：标配  2：无

    private Integer allPowerSunroof;//前后电动车窗 1：标配/标配  2：标配/无  3：无/无

    private Integer powerHouMirror;//后视镜电动调节 1：标配  2：无

    private Integer houMirrorHot;//后视镜加热 1：标配  2：无

    private Integer carId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPowerSunroof() {
        return powerSunroof;
    }

    public void setPowerSunroof(Integer powerSunroof) {
        this.powerSunroof = powerSunroof;
    }

    public Integer getAllSunroof() {
        return allSunroof;
    }

    public void setAllSunroof(Integer allSunroof) {
        this.allSunroof = allSunroof;
    }

    public Integer getPowerDoor() {
        return powerDoor;
    }

    public void setPowerDoor(Integer powerDoor) {
        this.powerDoor = powerDoor;
    }

    public Integer getGanyingBox() {
        return ganyingBox;
    }

    public void setGanyingBox(Integer ganyingBox) {
        this.ganyingBox = ganyingBox;
    }

    public Integer getGanyiBrush() {
        return ganyiBrush;
    }

    public void setGanyiBrush(Integer ganyiBrush) {
        this.ganyiBrush = ganyiBrush;
    }

    public Integer getHouBrush() {
        return houBrush;
    }

    public void setHouBrush(Integer houBrush) {
        this.houBrush = houBrush;
    }

    public Integer getAllPowerSunroof() {
        return allPowerSunroof;
    }

    public void setAllPowerSunroof(Integer allPowerSunroof) {
        this.allPowerSunroof = allPowerSunroof;
    }

    public Integer getPowerHouMirror() {
        return powerHouMirror;
    }

    public void setPowerHouMirror(Integer powerHouMirror) {
        this.powerHouMirror = powerHouMirror;
    }

    public Integer getHouMirrorHot() {
        return houMirrorHot;
    }

    public void setHouMirrorHot(Integer houMirrorHot) {
        this.houMirrorHot = houMirrorHot;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
