package com.jk.pojo;

import java.io.Serializable;

/**
 * 类描述：车辆信息表
 * 创建人：孙长江
 * 创建时间：2019/4/1618:54
 * 修改人：孙长江
 * 修改时间：2019/4/1618:54
 * 修改备注：
 */
public class CarBean implements Serializable {

    private static final long serialVersionUID = 4592182085915324838L;
    private  Integer id;

    private Integer brandId;//品牌Id

    private String brandName;//品牌名称

    private Integer series; //车辆系列id

    private String seriesName; //车辆系列名称

    private Double price; //价格

    private Double startPrice; //条查最小价格

    private Double endPrice; //条查最大价格

    private Integer carAgeId;//车龄Id

    private String carAgeName;//车龄

    private Integer gearbox;//变速箱  1自动 2手动

    private Integer carModel;//车型 两厢..四厢..suv等

    private String carModelName;//车型 Name

    private Integer mileageId;//里程表Id

    private String mileageName;//里程表Name

    private Integer carCerId;//排量表

    private String carCerNmae;//排量表Name

    private Integer carSeat; //座位数表

    private String carSeatName; //座位数表Name

    private Integer carFuel; //燃油类型表

    private String carFuelName; //燃油类型表Name

    private Integer color; //汽车颜色表

    private String colorName; //汽车颜色表Name

    private Integer license;//牌照 1本地 0外地

    private Integer drive;//驱动类型 0是两驱 1是四驱

    private Integer nationId; //国别表

    private String nationName; //国别表Name

    private Integer elseId; //其他配置

    private String elseName; //其他配置Name

    private Integer ownerId; //车主表

    private String ownerName; //车主名称

    private Integer storeId;//车辆所在店铺表

    private String storeName;//车辆所在店铺名称

    private String carLicense; //上牌时间

    private Integer areaId; //地区Id

    private String areaName; //地区

    private Integer start=0;//状态

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCarAgeId() {
        return carAgeId;
    }

    public void setCarAgeId(Integer carAgeId) {
        this.carAgeId = carAgeId;
    }

    public Integer getGearbox() {
        return gearbox;
    }

    public void setGearbox(Integer gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getCarModel() {
        return carModel;
    }

    public void setCarModel(Integer carModel) {
        this.carModel = carModel;
    }

    public Integer getMileageId() {
        return mileageId;
    }

    public void setMileageId(Integer mileageId) {
        this.mileageId = mileageId;
    }

    public Integer getCarCerId() {
        return carCerId;
    }

    public void setCarCerId(Integer carCerId) {
        this.carCerId = carCerId;
    }

    public Integer getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(Integer carSeat) {
        this.carSeat = carSeat;
    }

    public Integer getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(Integer carFuel) {
        this.carFuel = carFuel;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public Integer getDrive() {
        return drive;
    }

    public void setDrive(Integer drive) {
        this.drive = drive;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public Integer getElseId() {
        return elseId;
    }

    public void setElseId(Integer elseId) {
        this.elseId = elseId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
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

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    public String getCarAgeName() {
        return carAgeName;
    }

    public void setCarAgeName(String carAgeName) {
        this.carAgeName = carAgeName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getMileageName() {
        return mileageName;
    }

    public void setMileageName(String mileageName) {
        this.mileageName = mileageName;
    }

    public String getCarCerNmae() {
        return carCerNmae;
    }

    public void setCarCerNmae(String carCerNmae) {
        this.carCerNmae = carCerNmae;
    }

    public String getCarSeatName() {
        return carSeatName;
    }

    public void setCarSeatName(String carSeatName) {
        this.carSeatName = carSeatName;
    }

    public String getCarFuelName() {
        return carFuelName;
    }

    public void setCarFuelName(String carFuelName) {
        this.carFuelName = carFuelName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getElseName() {
        return elseName;
    }

    public void setElseName(String elseName) {
        this.elseName = elseName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
