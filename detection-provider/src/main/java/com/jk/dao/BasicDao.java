package com.jk.dao;

import com.jk.pojo.BasicBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BasicDao {

    //根据carId查询基本参数表
    @Select("SELECT * from t_basic where carId= #{carId}")
    List<BasicBean> queryBasic(Integer carId);

    //新增基本参数表
    @Insert("insert into t_basic(brandModel,vendor,level,engine,transmission,structure,volume,wheelbase,luggageVolume,weight,carId) \n" +
            "values(#{brandModel},#{vendor},#{level},#{engine},#{transmission},#{structure},#{volume},#{wheelbase},#{luggageVolume},#{weight},#{carId})")
    void addBasic(BasicBean basicBean);
}
