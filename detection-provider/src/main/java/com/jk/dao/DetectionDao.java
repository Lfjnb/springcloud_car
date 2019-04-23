package com.jk.dao;

import com.jk.pojo.CarDetectionBean;
import com.jk.pojo.DetectionBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DetectionDao {

    //根据检测项Pid查询每项检测
    @Select("select id,name as detectionName,pid from t_detection where pid = #{pid}")
    List<DetectionBean> queryDetectionByPid(Integer pid);

    //根据汽车id查询汽车异常项
    @Select("select * from t_car_detection where carId = #{carId}")
    List<CarDetectionBean> queryDetectionCarByCarId(Integer carId);

    //根据汽车Id跟检测项Pid查询出每项检测异常数量
    @Select("select count(1) from t_car_detection tcd left join t_detection td on tcd.detectionId=td.id where tcd.carId = #{carId} and td.pid = #{pid}")
    int queryDetectionCount(Integer carId,Integer pid);

    //新增异常检测
    @Insert("insert into t_car_detection(carId,detectionId) values(#{carId},#{detectionId})")
    void addCarDetection(CarDetectionBean carDetectionBean);

    //查询出除最上一级其他检测项
    @Select("select * from t_detection where pid != 0")
    List<DetectionBean> queryDetection();

    @Select("select td.id,td.name as detectionName from t_detection td left join t_car_detection tcd on td.id=tcd.detectionId where tcd.carId = #{carId}")
    List<DetectionBean> queryCarDetection(Integer carId);
}
