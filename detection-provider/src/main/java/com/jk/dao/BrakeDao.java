package com.jk.dao;

import com.jk.pojo.BrakeBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrakeDao {

    //根据carId查询底盘及制动表
    @Select("SELECT * from t_brake where carId = #{carId}")
    List<BrakeBean> queryBrake(Integer carId);

    //新增底盘及制动表
    @Insert("insert into t_brake(driveType,helpType,frontSuspension,rearSuspension,frontBrake,rearBrake,stopBrake,frontLuntai,rearLuntai,carId) \n" +
            "values(#{driveType},#{helpType},#{frontSuspension},#{rearSuspension},#{frontBrake},#{rearBrake},#{stopBrake},#{frontLuntai},#{rearLuntai},#{carId})")
    void addBrake(BrakeBean brakeBean);
}
