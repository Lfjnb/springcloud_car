package com.jk.pojo;

import java.io.Serializable;

/**
 * 发动机参数
 */
public class EngineBean implements Serializable {

    private static final long serialVersionUID = -8145030418619939776L;
    private Integer id;

    private Float displacement;//排量

    private String intakeType;//进气形式

    private String cylinder;//气缸

    private String horsepower;//最大马力

    private String torque;//最大扭矩

    private String fuel;//燃料类型

    private Integer fuelLabel;//燃油标号

    private String supply;//供油方式

    private String emissions;//排放标准

    private Integer carId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Float displacement) {
        this.displacement = displacement;
    }

    public String getIntakeType() {
        return intakeType;
    }

    public void setIntakeType(String intakeType) {
        this.intakeType = intakeType;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getFuelLabel() {
        return fuelLabel;
    }

    public void setFuelLabel(Integer fuelLabel) {
        this.fuelLabel = fuelLabel;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getEmissions() {
        return emissions;
    }

    public void setEmissions(String emissions) {
        this.emissions = emissions;
    }


}
