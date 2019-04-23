package com.jk.dao;

import com.jk.pojo.InternalBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InternalDao {

    //根据carId查询内部配置表
    @Select("select * from t_internal where carId = #{carId}")
    List<InternalBean> queryInternal(Integer carId);

    //新增内部配置表
    @Insert("insert into t_internal(allSteering,cruiseControl,cold,zidongCold,gPS,radar,daocheImage,leatherSeats,seatHot,carId)\n" +
            "values(#{allSteering},#{cruiseControl},#{cold},#{zidongCold},#{gPS},#{radar},#{daocheImage},#{leatherSeats},#{seatHot},#{carId})")
    void addInternal(InternalBean internalBean);
}
