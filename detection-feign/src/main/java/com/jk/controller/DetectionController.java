package com.jk.controller;

import com.jk.pojo.CarDetectionBean;
import com.jk.pojo.DetectionBean;
import com.jk.service.DetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class DetectionController {

    @Autowired
    private DetectionService detectionService;


    //根据汽车Id跟检测项Pid查询出每项检测异常
    @RequestMapping("queryDetectionStatus")
    @ResponseBody
    public List<DetectionBean> queryDetectionStatus(Integer carId,Integer pid){
        return detectionService.queryDetectionStatus(carId,pid);
    }

    //查询检测表异常状态数量
    @RequestMapping("queryDetectionCount")
    @ResponseBody
    public HashMap<String , Object> queryDetectionCount(Integer carId, Integer pid){
        return detectionService.queryDetectionCount(carId,pid);
    }

    //添加检测异常信息
    @RequestMapping("addCarDetection")
    @ResponseBody
    public Boolean addCarDetection(CarDetectionBean carDetectionBean){
        return detectionService.addCarDetection(carDetectionBean);
    }

    //查询出除最上一级其他检测项
    @RequestMapping("queryDetection")
    @ResponseBody
    public List<DetectionBean> queryDetection(){
        return detectionService.queryDetection();
    }

    //查询所有异常根据carId
    @RequestMapping("queryCarDetection")
    @ResponseBody
    public List<DetectionBean> queryCarDetection(Integer carId){
        return detectionService.queryCarDetection(carId);
    }


}
