package com.jk.service;

import com.jk.pojo.CarDetectionBean;
import com.jk.pojo.DetectionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@FeignClient(value = "detection-provider")
public interface DetectionService {

    //根据汽车Id跟检测项Pid查询出每项检测异常
    @RequestMapping("queryDetectionStatus")
    List<DetectionBean> queryDetectionStatus(@RequestParam Integer carId,@RequestParam Integer pid);

    //查询检测表异常状态数量
    @RequestMapping("queryDetectionCount")
    HashMap<String, Object> queryDetectionCount(@RequestParam Integer carId,@RequestParam  Integer pid);

    //新增异常检测
    @RequestMapping("addCarDetection")
    Boolean addCarDetection(CarDetectionBean carDetectionBean);

    //查询出除最上一级其他检测项
    @RequestMapping("queryDetection")
    List<DetectionBean> queryDetection();

    //查询所有异常根据carId
    @RequestMapping("queryCarDetection")
    List<DetectionBean> queryCarDetection(@RequestParam Integer carId);
}
