package com.jk.pojo;


import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 类描述：车辆信息表
 * 创建人：孙长江
 * 创建时间：2019/4/1618:54
 * 修改人：孙长江
 * 修改时间：2019/4/1618:54
 * 修改备注：
 */
@Document(collection = "sellCar")
public class CarBean1 implements Serializable {

    private static final long serialVersionUID = 4592182085915324838L;

    private  Integer id;

    private String carName;//汽车名称

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

    private String ownerId; //车主表

    private String ownerName; //车主名称

    private Integer storeId;//车辆所在店铺表

    private String storeName;//车辆所在店铺名称

    private String carLicense; //上牌时间s

    private Integer areaId; //地区Id

    private String areaName; //地区

    private Integer start=0;//状态

    private String imgUrl; //图片路径

    private Date sellCarTime;//卖车时间存入mongo

    public Date getSellCarTime() {
        return sellCarTime;
    }

    public void setSellCarTime(Date sellCarTime) {
        this.sellCarTime = sellCarTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getCarAgeId() {
        return carAgeId;
    }

    public void setCarAgeId(Integer carAgeId) {
        this.carAgeId = carAgeId;
    }

    public String getCarAgeName() {
        return carAgeName;
    }

    public void setCarAgeName(String carAgeName) {
        this.carAgeName = carAgeName;
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

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public Integer getMileageId() {
        return mileageId;
    }

    public void setMileageId(Integer mileageId) {
        this.mileageId = mileageId;
    }

    public String getMileageName() {
        return mileageName;
    }

    public void setMileageName(String mileageName) {
        this.mileageName = mileageName;
    }

    public Integer getCarCerId() {
        return carCerId;
    }

    public void setCarCerId(Integer carCerId) {
        this.carCerId = carCerId;
    }

    public String getCarCerNmae() {
        return carCerNmae;
    }

    public void setCarCerNmae(String carCerNmae) {
        this.carCerNmae = carCerNmae;
    }

    public Integer getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(Integer carSeat) {
        this.carSeat = carSeat;
    }

    public String getCarSeatName() {
        return carSeatName;
    }

    public void setCarSeatName(String carSeatName) {
        this.carSeatName = carSeatName;
    }

    public Integer getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(Integer carFuel) {
        this.carFuel = carFuel;
    }

    public String getCarFuelName() {
        return carFuelName;
    }

    public void setCarFuelName(String carFuelName) {
        this.carFuelName = carFuelName;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public Integer getElseId() {
        return elseId;
    }

    public void setElseId(Integer elseId) {
        this.elseId = elseId;
    }

    public String getElseName() {
        return elseName;
    }

    public void setElseName(String elseName) {
        this.elseName = elseName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "CarBean{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", series=" + series +
                ", seriesName='" + seriesName + '\'' +
                ", price=" + price +
                ", startPrice=" + startPrice +
                ", endPrice=" + endPrice +
                ", carAgeId=" + carAgeId +
                ", carAgeName='" + carAgeName + '\'' +
                ", gearbox=" + gearbox +
                ", carModel=" + carModel +
                ", carModelName='" + carModelName + '\'' +
                ", mileageId=" + mileageId +
                ", mileageName='" + mileageName + '\'' +
                ", carCerId=" + carCerId +
                ", carCerNmae='" + carCerNmae + '\'' +
                ", carSeat=" + carSeat +
                ", carSeatName='" + carSeatName + '\'' +
                ", carFuel=" + carFuel +
                ", carFuelName='" + carFuelName + '\'' +
                ", color=" + color +
                ", colorName='" + colorName + '\'' +
                ", license=" + license +
                ", drive=" + drive +
                ", nationId=" + nationId +
                ", nationName='" + nationName + '\'' +
                ", elseId=" + elseId +
                ", elseName='" + elseName + '\'' +
                ", ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", carLicense='" + carLicense + '\'' +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", start=" + start +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
