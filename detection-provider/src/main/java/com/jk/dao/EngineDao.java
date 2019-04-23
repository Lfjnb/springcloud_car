package com.jk.dao;

import com.jk.pojo.EngineBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EngineDao {

    //根据carId查询发动机参数表
    @Select("select * from t_engine where carId = #{carId}")
    List<EngineBean> queryEngine(Integer carId);

    //新增发动机参数表
    @Insert("insert into t_engine(displacement,intakeType,cylinder,horsepower,torque,fuel,fuelLabel,supply,emissions,carId)\n" +
            "values(#{displacement},#{intakeType},#{cylinder},#{horsepower},#{torque},#{fuel},#{fuelLabel},#{supply},#{emissions},#{carId})\n")
    void addEngine(EngineBean engineBean);
}
